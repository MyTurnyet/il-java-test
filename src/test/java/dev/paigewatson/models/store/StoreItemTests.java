package dev.paigewatson.models.store;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.discounts.DiscountRule;
import dev.paigewatson.models.discounts.UnlimitedDiscountRule;
import dev.paigewatson.service.io.CommandLineWriter;
import dev.paigewatson.service.io.OutputWriter;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.stream.Stream;

import static dev.paigewatson.models.store.Item.APPLE_NAME;
import static dev.paigewatson.models.store.Item.BREAD_NAME;
import static dev.paigewatson.models.store.Item.MILK_NAME;
import static dev.paigewatson.models.store.Item.SOUP_NAME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class StoreItemTests
{

    private static Stream<Arguments> provideStringsForMatchItem()
    {
        return Stream.of(
                Arguments.of(Item.Soup(), SOUP_NAME, new Pennies(65)),
                Arguments.of(Item.Bread(), BREAD_NAME, new Pennies(80)),
                Arguments.of(Item.Apple(), APPLE_NAME, new Pennies(10)),
                Arguments.of(Item.Milk(), MILK_NAME, new Pennies(130))
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForMatchItem")
    public void should_matchSoup_byName(StoreItem storeItem, String expectedName, Pennies expectedCost)
    {
        //assign
        //act
        final boolean hasSameName = storeItem.hasSameName(expectedName);
        final Pennies total = storeItem.AddCostToTotal(new Pennies());
        //assert
        assertThat(hasSameName).isTrue();
        assertThat(total).isEqualTo(expectedCost);
    }

    @Test
    public void should_itemsCost_andReturnCostPlusZero()
    {
        //assign
        final StoreItem soup = Item.Soup();

        //act
        final Pennies total = soup.AddCostToTotal(new Pennies());
        //assert
        assertThat(total).isEqualTo(new Pennies(65));
    }

    @Test
    public void should_itemsCost_andReturnCostPlusOneHundredAndTen()
    {
        //assign
        final StoreItem soup = Item.Soup();

        //act
        final Pennies total = soup.AddCostToTotal(new Pennies(110));
        //assert
        assertThat(total).isEqualTo(new Pennies(175));
    }

    @Test
    public void should_applyDiscountToApple()
    {
        //assign
        final StoreItem storeItem = Item.Apple();
        final LocalDate discountStart = LocalDate.now().minusDays(1);
        final LocalDate discountEnd = discountStart.plusWeeks(7);
        final DiscountRule discountRule = new UnlimitedDiscountRule(10, APPLE_NAME);
        //act
        final Pennies total = storeItem.amountToSubtractForDiscount(discountRule);
        //assert
        assertThat(total).isEqualTo(new Pennies(1));
    }

    @Test
    public void should_NotApplyDiscountToApple_becauseNameDoesntMatch()
    {
        //assign
        final StoreItem storeItem = Item.Apple();
        final LocalDate discountStart = LocalDate.now().minusDays(1);
        final LocalDate discountEnd = discountStart.plusWeeks(7);
        final DiscountRule discountRule = new UnlimitedDiscountRule(10, BREAD_NAME);
        //act
        final Pennies total = storeItem.amountToSubtractForDiscount(discountRule);
        //assert
        assertThat(total).isEqualTo(new Pennies());
    }

    @Test
    public void should_writeItem_toOutputWriter()
    {
        //assign
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outputStream);
        final OutputWriter commandLineWriter = new CommandLineWriter(printStream);

        final StoreItem storeItem = Item.Apple();

        //act
        storeItem.writeNameToOutput(commandLineWriter);
        //assert
        assertThat(outputStream.toString()).isEqualTo("apple\r\n");
    }
}

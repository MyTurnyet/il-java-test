package dev.paigewatson.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static dev.paigewatson.models.Item.APPLE_NAME;
import static dev.paigewatson.models.Item.BREAD_NAME;
import static dev.paigewatson.models.Item.MILK_NAME;
import static dev.paigewatson.models.Item.SOUP_NAME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class StoreItemTests
{

    private static Stream<Arguments> provideStringsForMatchItem()
    {
        return Stream.of(
                Arguments.of(Item.Soup(), SOUP_NAME, 65),
                Arguments.of(Item.Bread(), BREAD_NAME, 80),
                Arguments.of(Item.Apple(), APPLE_NAME, 10),
                Arguments.of(Item.Milk(), MILK_NAME, 130)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForMatchItem")
    public void should_matchSoup_byName(StoreItem storeItem, String expectedName, int expectedCost)
    {
        //assign
        //act
        final boolean hasSameName = storeItem.hasSameName(expectedName);
        final int total = storeItem.AddCostToTotal(0);
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
        final int total = soup.AddCostToTotal(0);
        //assert
        assertThat(total).isEqualTo(65);
    }

    @Test
    public void should_itemsCost_andReturnCostPlusOneHundredAndTen()
    {
        //assign
        final StoreItem soup = Item.Soup();

        //act
        final int total = soup.AddCostToTotal(110);
        //assert
        assertThat(total).isEqualTo(175);
    }

    @Test
    public void should_applyDiscountToApple()
    {
        //assign
        final StoreItem storeItem = Item.Apple();
        final LocalDate discountStart = LocalDate.now().minusDays(1);
        final LocalDate discountEnd = discountStart.plusWeeks(7);
        final DiscountRule discountRule = new DiscountRule(APPLE_NAME, 10, discountStart, discountEnd);
        //act
        final int total = storeItem.AddCostToTotal(discountRule, 0);
        //assert
        assertThat(total).isEqualTo(9);
    }


}

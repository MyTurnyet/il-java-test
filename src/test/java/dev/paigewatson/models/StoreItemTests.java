package dev.paigewatson.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class StoreItemTests
{

    private static Stream<Arguments> provideStringsForMatchItem() {
        return Stream.of(
                Arguments.of(Item.Soup(), "soup", 65)
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
    public void should_itsCost_andReturn65()
    {
        //assign
        final StoreItem soup = Item.Soup();

        //act
        final int total = soup.AddCostToTotal(0);
        //assert
        assertThat(total).isEqualTo(65);
    }

    @Test
    public void should_itsCost_andReturn175()
    {
        //assign
        final StoreItem soup = Item.Soup();

        //act
        final int total = soup.AddCostToTotal(110);
        //assert
        assertThat(total).isEqualTo(175);
    }
}

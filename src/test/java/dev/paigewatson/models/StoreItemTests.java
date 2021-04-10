package dev.paigewatson.models;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StoreItemTests
{
    @Nested
    @Tag("Unit")
    class UnitTests
    {
        @Test
        public void should_createStoreItem()
        {
            //assign
            String name = "soup";
            String unit = "tin";
            int cost = 65;
            final StoreItem storeItem = new StoreItem(name, unit, cost);

            //act
            final String wordingForCount = storeItem.getWordingForCount(1);
            //assert
            assertThat(wordingForCount).isEqualTo("1 tin of soup");
        }
    }
}

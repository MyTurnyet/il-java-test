package dev.paigewatson.models;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StoreItemTests
{
    @Nested
    @Tag("Unit")
    class SoupTests
    {
        @Test
        public void should_createStoreItem()
        {
            //assign
            final StoreItem soup = new Soup();

            //act
            final String wordingForCount = soup.getWordingForCount(1);
            //assert
            assertThat(wordingForCount).isEqualTo("1 tin of soup");
        }
    }
}

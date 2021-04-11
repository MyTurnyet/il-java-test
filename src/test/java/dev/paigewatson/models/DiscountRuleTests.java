package dev.paigewatson.models;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static dev.paigewatson.models.Item.APPLE_NAME;
import static dev.paigewatson.models.Item.BREAD_NAME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class DiscountRuleTests
{
    @Nested
    public class UnlimitedDiscountRuleTests
    {
        @Test
        public void should_Discount_by10Percent()
        {
            //assign
            final DiscountRule discountRule = getDiscountRuleForTest(10);

            //act
            final int discountedAmount = discountRule.discountedAmount(100);
            //assert
            assertThat(discountedAmount).isEqualTo(10);
        }

        @Test
        public void should_Discount_by50Percent()
        {
            //assign
            final DiscountRule discountRule = getDiscountRuleForTest(50);

            //act
            final int discountedAmount = discountRule.discountedAmount(80);
            //assert
            assertThat(discountedAmount).isEqualTo(40);
        }

        @Test
        public void should_MatchName()
        {
            //assign
            final DiscountRule discountRule = getDiscountRuleForTest(50);

            //act
            final boolean matchesItemName = discountRule.matchesItemName(APPLE_NAME);
            //assert
            assertThat(matchesItemName).isTrue();
        }

        @Test
        public void should_notMatchName()
        {
            //assign
            final DiscountRule discountRule = getDiscountRuleForTest(50);

            //act
            final boolean matchesItemName = discountRule.matchesItemName(BREAD_NAME);
            //assert
            assertThat(matchesItemName).isFalse();
        }

        private DiscountRule getDiscountRuleForTest(int discountPercentage)
        {
            return new UnlimitedDiscountRule(discountPercentage, APPLE_NAME);
        }
    }
}

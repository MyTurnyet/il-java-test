package dev.paigewatson.models.discounts;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.store.ItemName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
            final DiscountRule discountRule = getAppleDiscountRuleForTest(10);
            final Pennies fullCost = new Pennies(100);
            //act
            final Pennies discountedAmount = discountRule.discountedAmount(fullCost);
            //assert
            assertThat(discountedAmount).isEqualTo(new Pennies(10));
        }

        @Test
        public void should_Discount_by50Percent()
        {
            //assign
            final DiscountRule discountRule = getAppleDiscountRuleForTest(50);
            final Pennies fullCost = new Pennies(80);

            //act
            final Pennies discountedAmount = discountRule.discountedAmount(fullCost);
            //assert
            assertThat(discountedAmount).isEqualTo(new Pennies(40));
        }

        @Test
        public void should_MatchName()
        {
            //assign
            final DiscountRule discountRule = getAppleDiscountRuleForTest(50);

            //act
            final boolean matchesItemName = discountRule.matchesItemName(ItemName.Apple);
            //assert
            assertThat(matchesItemName).isTrue();
        }

        @Test
        public void should_notMatchName()
        {
            //assign
            final DiscountRule discountRule = getAppleDiscountRuleForTest(50);

            //act
            final boolean matchesItemName = discountRule.matchesItemName(ItemName.Bread);
            //assert
            assertThat(matchesItemName).isFalse();
        }

        private DiscountRule getAppleDiscountRuleForTest(int discountPercentage)
        {
            return new UnlimitedDiscountRule(discountPercentage, ItemName.Apple);
        }
    }
}

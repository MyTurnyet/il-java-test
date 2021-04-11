package dev.paigewatson.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

    @Tag("Unit")
public class DiscountRuleTests
{
    @Test
    public void should_Discount_by10Percent()
    {
        //assign
        final DiscountRule discountRule = new DiscountRule("apple", 10);

        //act
        final int discountedAmount = discountRule.discountedAmount(100);
        //assert
        assertThat(discountedAmount).isEqualTo(90);
    }
    @Test
    public void should_Discount_by50Percent()
    {
        //assign
        final DiscountRule discountRule = new DiscountRule("apple", 50);

        //act
        final int discountedAmount = discountRule.discountedAmount(80);
        //assert
        assertThat(discountedAmount).isEqualTo(40);
    }
}

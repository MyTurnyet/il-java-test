package dev.paigewatson.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

    @Tag("Unit")
public class DiscountRuleTests
{
    @Test
    public void should_Discount_by10Percent()
    {
        //assign
        final LocalDate discountStart = LocalDate.now().plusDays(1);
        final LocalDate discountEnd = discountStart.plusWeeks(7);
        final DiscountRule discountRule = new DiscountRule("apple", 10, discountStart, discountEnd);

        //act
        final int discountedAmount = discountRule.discountedAmount(100);
        //assert
        assertThat(discountedAmount).isEqualTo(90);
    }
    @Test
    public void should_Discount_by50Percent()
    {
        //assign
        final LocalDate discountStart = LocalDate.now().plusDays(1);
        final LocalDate discountEnd = discountStart.plusWeeks(7);
        final DiscountRule discountRule = new DiscountRule("apple", 50, discountStart, discountEnd);

        //act
        final int discountedAmount = discountRule.discountedAmount(80);
        //assert
        assertThat(discountedAmount).isEqualTo(40);
    }

    @Test
    public void should_showDiscount_InEffect()
    {
        //assign
        final LocalDate today = LocalDate.now();
        final LocalDate discountStart = LocalDate.now().minusDays(1);
        final LocalDate discountEnd = discountStart.plusWeeks(7);

        final DiscountRule discountRule = new DiscountRule("apples", 50, discountStart, discountEnd);
        //act
        final boolean inEffect = discountRule.isInEffect(today);
        //assert
        assertThat(inEffect).isTrue();
    }

    @Test
    public void should_showDiscount_notInEffect_beforeStartDate()
    {
        //assign
        final LocalDate today = LocalDate.now();
        final LocalDate discountStart = LocalDate.now().plusDays(1);
        final LocalDate discountEnd = discountStart.plusWeeks(7);

        final DiscountRule discountRule = new DiscountRule("apples", 50, discountStart, discountEnd);
        //act
        final boolean inEffect = discountRule.isInEffect(today);
        //assert
        assertThat(inEffect).isFalse();
    }
    @Test
    public void should_showDiscount_notInEffect_afterEndDate()
    {
        //assign
        final LocalDate today = LocalDate.now();
        final LocalDate discountStart = LocalDate.now().minusDays(14);
        final LocalDate discountEnd = today.minusDays(1);

        final DiscountRule discountRule = new DiscountRule("apples", 50, discountStart, discountEnd);
        //act
        final boolean inEffect = discountRule.isInEffect(today);
        //assert
        assertThat(inEffect).isFalse();
    }
}
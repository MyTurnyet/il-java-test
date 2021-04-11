package dev.paigewatson.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static dev.paigewatson.models.Item.APPLE_NAME;
import static dev.paigewatson.models.Item.BREAD_NAME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class DiscountRuleTests
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
    public void should_showDiscount_InEffect()
    {
        //assign
        final LocalDate today = LocalDate.now();
        final DiscountRule discountRule = getDiscountRuleForTest(50);
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
        final DiscountRule discountRule = getDiscountRuleForTest(50, 1, 7);
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

        final DiscountRule discountRule = getDiscountRuleForTest(50, -1, -1);
        //act
        final boolean inEffect = discountRule.isInEffect(today);
        //assert
        assertThat(inEffect).isFalse();
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
        return getDiscountRuleForTest(discountPercentage, 0, 0);
    }

    private DiscountRule getDiscountRuleForTest(int discountPercentage, int startDayFromNow, int endDaysFromNow)
    {
        final LocalDate today = LocalDate.now();
        final LocalDate discountStart = today.plusDays(startDayFromNow);
        final LocalDate discountEnd = discountStart.plusDays(endDaysFromNow);
        return new DiscountRule(APPLE_NAME, 1, discountStart, discountEnd, discountPercentage, APPLE_NAME);
    }
}

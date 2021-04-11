package dev.paigewatson.service;

import dev.paigewatson.models.DiscountRule;
import dev.paigewatson.models.Item;
import dev.paigewatson.models.StoreItem;
import dev.paigewatson.models.UnlimitedDiscountRule;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static dev.paigewatson.models.Item.APPLE_NAME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class DiscountServiceTests
{
    @Test
    public void should_processDiscountRules_forOneApple()
    {
        //assign
        ArrayList<StoreItem> items = new ArrayList<>();
        items.add(Item.Apple());

        final DiscountRule appleDiscount = getDiscountRuleForTest();
        final List<DiscountRule> discountRules = new ArrayList<>();
        discountRules.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discountRules);

        //act
        final int discountedAmount = discountService.getTotalCreditDiscounts(items);
        //assert
        assertThat(discountedAmount).isEqualTo(1);
    }

    @Test
    public void should_processDiscountRules_forThreeApples()
    {
        //assign
        ArrayList<StoreItem> items = new ArrayList<>();
        items.add(Item.Apple());
        items.add(Item.Apple());
        items.add(Item.Apple());

        final DiscountRule appleDiscount = getDiscountRuleForTest();
        final List<DiscountRule> discountRules = new ArrayList<>();
        discountRules.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discountRules);

        //act
        final int discountedAmount = discountService.getTotalCreditDiscounts(items);
        //assert
        assertThat(discountedAmount).isEqualTo(3);
    }

    @Test
    public void should_processDiscountRules_forTwoApplesAndMilk()
    {
        //assign
        ArrayList<StoreItem> items = new ArrayList<>();
        items.add(Item.Apple());
        items.add(Item.Apple());
        items.add(Item.Apple());

        final DiscountRule appleDiscount = getDiscountRuleForTest();
        final List<DiscountRule> discountRules = new ArrayList<>();
        discountRules.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discountRules);

        //act
        final int discountedAmount = discountService.getTotalCreditDiscounts(items);
        //assert
        assertThat(discountedAmount).isEqualTo(3);
    }

    private DiscountRule getDiscountRuleForTest()
    {
        return new UnlimitedDiscountRule(10, APPLE_NAME);
    }
}

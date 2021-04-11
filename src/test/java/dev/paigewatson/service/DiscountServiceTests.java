package dev.paigewatson.service;

import dev.paigewatson.models.DiscountRule;
import dev.paigewatson.models.Item;
import dev.paigewatson.models.StoreItem;
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
    public void should_processDiscountRulesForApples()
    {
        //assign
        ArrayList<StoreItem> items = new ArrayList<>();
        items.add(Item.Apple());

        final DiscountRule appleDiscount = getDiscountRuleForTest();
        final List<DiscountRule> discountRules = new ArrayList<>();
        discountRules.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discountRules);

        //act
        final int discountedAmount = discountService.applyDiscounts(items);
        //assert
        assertThat(discountedAmount).isEqualTo(1);
    }

    private DiscountRule getDiscountRuleForTest()
    {
        return new DiscountRule(10, APPLE_NAME);
    }
}

package dev.paigewatson.service;

import dev.paigewatson.models.Discount;
import dev.paigewatson.models.DiscountRule;
import dev.paigewatson.models.Item;
import dev.paigewatson.models.StoreItem;
import dev.paigewatson.models.UnlimitedDiscountRule;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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

        final LocalDate today = LocalDate.now();
        final Discount appleDiscount = getAppleDiscount(today);
        final List<Discount> discounts = new ArrayList<>();
        discounts.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discounts);


        //act
        final int discountedAmount = discountService.getTotalCreditDiscounts(today, items);
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

        final LocalDate today = LocalDate.now();
        final Discount appleDiscount = getAppleDiscount(today);
        final List<Discount> discounts = new ArrayList<>();
        discounts.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discounts);

        //act
        final int discountedAmount = discountService.getTotalCreditDiscounts(today, items);
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
        items.add(Item.Milk());

        final LocalDate today = LocalDate.now();
        final Discount appleDiscount = getAppleDiscount(today);
        final List<Discount> discounts = new ArrayList<>();
        discounts.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discounts);

        //act
        final int discountedAmount = discountService.getTotalCreditDiscounts(today, items);
        //assert
        assertThat(discountedAmount).isEqualTo(2);
    }
    @Test
    public void shouldNot_processDiscountRules_invalidDiscounts()
    {
        //assign
        ArrayList<StoreItem> items = new ArrayList<>();
        items.add(Item.Apple());
        items.add(Item.Apple());
        items.add(Item.Milk());

        final LocalDate today = LocalDate.now();
        final Discount appleDiscount = getAppleDiscount(today);
        final List<Discount> discounts = new ArrayList<>();
        discounts.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discounts);

        //act
        final int discountedAmount = discountService.getTotalCreditDiscounts(today.minusDays(3), items);
        //assert
        assertThat(discountedAmount).isEqualTo(0);
    }

    private Discount getAppleDiscount(LocalDate saleDate)
    {
        final DiscountRule appleDiscountRule = getDiscountRuleForTest();
        return new Discount(APPLE_NAME, 1, saleDate, saleDate, appleDiscountRule);
    }

    private DiscountRule getDiscountRuleForTest()
    {
        return new UnlimitedDiscountRule(10, APPLE_NAME);
    }
}

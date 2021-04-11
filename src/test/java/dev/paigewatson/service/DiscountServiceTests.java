package dev.paigewatson.service;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.discounts.Discount;
import dev.paigewatson.models.discounts.DiscountFactory;
import dev.paigewatson.models.store.Item;
import dev.paigewatson.models.store.StoreItem;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        final Discount appleDiscount = DiscountFactory.applesDiscount();
        final List<Discount> discounts = new ArrayList<>();
        discounts.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discounts);


        //act
        final Pennies discountedAmount = discountService.getTotalCreditDiscounts(today.plusDays(3), items);
        //assert
        assertThat(discountedAmount).isEqualTo(new Pennies(1));
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
        final Discount appleDiscount = DiscountFactory.applesDiscount();
        final List<Discount> discounts = new ArrayList<>();
        discounts.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discounts);

        //act
        final Pennies discountedAmount = discountService.getTotalCreditDiscounts(today.plusDays(3), items);
        //assert
        assertThat(discountedAmount).isEqualTo(new Pennies(3));
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
        final Discount appleDiscount = DiscountFactory.applesDiscount();
        final List<Discount> discounts = new ArrayList<>();
        discounts.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discounts);

        //act
        final Pennies discountedAmount = discountService.getTotalCreditDiscounts(today.plusDays(3), items);
        //assert
        assertThat(discountedAmount).isEqualTo(new Pennies(2));
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
        final Discount appleDiscount = DiscountFactory.applesDiscount();
        final List<Discount> discounts = new ArrayList<>();
        discounts.add(appleDiscount);

        final DiscountService discountService = new DiscountService(discounts);

        //act
        final Pennies discountedAmount = discountService.getTotalCreditDiscounts(today.minusDays(3), items);
        //assert
        assertThat(discountedAmount).isEqualTo(new Pennies());
    }
}

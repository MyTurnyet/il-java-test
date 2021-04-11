package dev.paigewatson.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static dev.paigewatson.models.Item.APPLE_NAME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class DiscountTests
{
    @Test
    public void should_applyDiscount_whenRequirementsName_andAmount_match()
    {
        //assign
        final LocalDate today = LocalDate.now();
        final DiscountRule discountRule = new DiscountRule(50, APPLE_NAME);
        final Discount discount = new Discount(APPLE_NAME, 1, today, today, discountRule);

        final List<StoreItem> storeItems = new ArrayList<>();
        storeItems.add(Item.Apple());

        //act
        final boolean canBeApplied = discount.isValid(today, storeItems);
        //assert
        assertThat(canBeApplied).isTrue();
    }

    @Test
    public void shouldNot_applyDiscount_whenRequiredAmount_isLessThanActualCount()
    {
        //assign
        final LocalDate today = LocalDate.now();
        final DiscountRule discountRule = new DiscountRule(50, APPLE_NAME);
        final Discount discount = new Discount(APPLE_NAME, 2, LocalDate.now(), LocalDate.now(), discountRule);

        final List<StoreItem> storeItems = new ArrayList<>();
        storeItems.add(Item.Apple());

        //act
        final boolean canBeApplied = discount.isValid(today, storeItems);
        //assert
        assertThat(canBeApplied).isFalse();
    }

    @Test
    public void shouldNot_applyDiscount_whenRequiredItems_dontExist()
    {
        //assign
        final LocalDate today = LocalDate.now();
        final DiscountRule discountRule = new DiscountRule(50, APPLE_NAME);
        final Discount discount = new Discount(APPLE_NAME, 1, today, today, discountRule);

        final List<StoreItem> storeItems = new ArrayList<>();
        storeItems.add(Item.Bread());

        //act
        final boolean canBeApplied = discount.isValid(today, storeItems);
        //assert
        assertThat(canBeApplied).isFalse();
    }

    @Test
    public void shouldNot_applyDiscount_whenSaleDate_isAfterEndDate()
    {
        //assign
        final LocalDate today = LocalDate.now();
        final DiscountRule discountRule = new DiscountRule(50, APPLE_NAME);
        final Discount discount = new Discount(APPLE_NAME, 1, today.minusDays(1), today.minusDays(1), discountRule);

        final List<StoreItem> storeItems = new ArrayList<>();
        storeItems.add(Item.Apple());

        //act
        final boolean canBeApplied = discount.isValid(today, storeItems);
        //assert
        assertThat(canBeApplied).isFalse();
    }
    @Test
    public void shouldNot_applyDiscount_whenSaleDate_isBeforeStartDate()
    {
        //assign
        final LocalDate today = LocalDate.now();
        final DiscountRule discountRule = new DiscountRule(50, APPLE_NAME);
        final Discount discount = new Discount(APPLE_NAME, 1, today.plusDays(1), today.plusDays(1), discountRule);

        final List<StoreItem> storeItems = new ArrayList<>();
        storeItems.add(Item.Apple());

        //act
        final boolean canBeApplied = discount.isValid(today, storeItems);
        //assert
        assertThat(canBeApplied).isFalse();
    }
}

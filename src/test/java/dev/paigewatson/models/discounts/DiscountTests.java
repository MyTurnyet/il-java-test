package dev.paigewatson.models.discounts;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.store.Item;
import dev.paigewatson.models.store.ItemName;
import dev.paigewatson.models.store.StoreItem;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class DiscountTests
{
    @Test
    public void should_applyDiscount_whenRequirementsName_andAmount_match()
    {
        //assign
        final LocalDate today = LocalDate.now();
        final DiscountRule discountRule = new UnlimitedDiscountRule(50, ItemName.Apple);
        final Discount discount = new Discount(ItemName.Apple, 1, today, today, discountRule);

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
        final DiscountRule discountRule = new UnlimitedDiscountRule(50, ItemName.Apple);
        final Discount discount = new Discount(ItemName.Apple, 2, LocalDate.now(), LocalDate.now(), discountRule);

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
        final DiscountRule discountRule = new UnlimitedDiscountRule(50, ItemName.Apple);
        final Discount discount = new Discount(ItemName.Apple, 1, today, today, discountRule);

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
        final DiscountRule discountRule = new UnlimitedDiscountRule(50, ItemName.Apple);
        final Discount discount = new Discount(ItemName.Apple, 1, today.minusDays(1), today.minusDays(1), discountRule);

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
        final DiscountRule discountRule = new UnlimitedDiscountRule(50, ItemName.Apple);
        final Discount discount = new Discount(ItemName.Apple, 1, today.plusDays(1), today.plusDays(1), discountRule);

        final List<StoreItem> storeItems = new ArrayList<>();
        storeItems.add(Item.Apple());

        //act
        final boolean canBeApplied = discount.isValid(today, storeItems);
        //assert
        assertThat(canBeApplied).isFalse();
    }

    @Test
    public void should_applyDiscount_toOneApple()
    {
        final LocalDate today = LocalDate.now();
        final DiscountRule discountRule = new UnlimitedDiscountRule(50, ItemName.Apple);
        final Discount discount = new Discount(ItemName.Apple, 1, today, today, discountRule);

        final List<StoreItem> storeItems = new ArrayList<>();
        storeItems.add(Item.Apple());

        //act
        final Pennies amountToSubtract = discount.apply(today, storeItems);
        //assert
        assertThat(amountToSubtract).isEqualTo(new Pennies(5));
    }

    @Test
    public void should_applyDiscount_whenValid_onlyToOneApples()
    {
        final LocalDate today = LocalDate.now();
        final DiscountRule discountRule = new UnlimitedDiscountRule(50, ItemName.Apple);
        final Discount discount = new Discount(ItemName.Apple, 1, today, today, discountRule);

        final List<StoreItem> storeItems = new ArrayList<>();
        storeItems.add(Item.Apple());
        storeItems.add(Item.Milk());

        //act
        final Pennies amountToSubtract = discount.apply(today, storeItems);
        //assert
        assertThat(amountToSubtract).isEqualTo(new Pennies(5));
    }

    @Test
    public void shouldNot_applyDiscount_whenInvalid()
    {
        final LocalDate today = LocalDate.now();
        final DiscountRule discountRule = new UnlimitedDiscountRule(50, ItemName.Apple);
        final Discount discount = new Discount(ItemName.Apple, 1, today.minusDays(1), today.minusDays(1), discountRule);

        final List<StoreItem> storeItems = new ArrayList<>();
        storeItems.add(Item.Apple());
        storeItems.add(Item.Milk());

        //act
        final Pennies amountToSubtract = discount.apply(today, storeItems);
        //assert
        assertThat(amountToSubtract).isEqualTo(new Pennies());
    }
}

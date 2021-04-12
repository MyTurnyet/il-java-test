package dev.paigewatson.models.discounts;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.store.ItemName;
import dev.paigewatson.models.store.StoreItem;

import java.time.LocalDate;
import java.util.List;

public class Discount
{
    private final ItemName requiredItemName;
    private final int requireNumber;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final DiscountRule discountRule;

    public Discount(ItemName requiredItemName, int requireNumber, LocalDate startDate, LocalDate endDate, DiscountRule discountRule)
    {
        this.requiredItemName = requiredItemName;
        this.requireNumber = requireNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountRule = discountRule;
    }

    public boolean isValid(LocalDate saleDate, List<StoreItem> storeItems)
    {
        if (endDate.isBefore(saleDate) || startDate.isAfter(saleDate)) return false;
        final long matchingItemsCount = storeItems.stream().filter(storeItem -> storeItem.hasSameName(requiredItemName)).count();
        return matchingItemsCount >= requireNumber;
    }

    public Pennies apply(LocalDate saleDate, List<StoreItem> storeItems)
    {
        if (!isValid(saleDate, storeItems)) return new Pennies();
        Pennies sum = new Pennies();
        for (StoreItem storeItem : storeItems)
        {
            sum = sum.add(storeItem.amountToSubtractForDiscount(discountRule));
        }
        return sum;
    }
}

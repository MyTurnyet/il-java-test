package dev.paigewatson.models;

import java.time.LocalDate;
import java.util.List;

public class Discount
{
    private final String requiredItemName;
    private final int requireNumber;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final DiscountRule discountRule;

    public Discount(String requiredItemName, int requireNumber, LocalDate startDate, LocalDate endDate, DiscountRule discountRule)
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

    public int apply(LocalDate saleDate, List<StoreItem> storeItems)
    {
        if(!isValid(saleDate,storeItems)) return 0;
        return storeItems.stream().mapToInt(storeItem -> storeItem.amountToSubtractForDiscount(discountRule)).sum();
    }
}

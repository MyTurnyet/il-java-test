package dev.paigewatson.models;

import java.time.LocalDate;
import java.util.List;

public class Discount
{
    private final String requiredItemName;
    private final int requireNumber;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Discount(String requiredItemName, int requireNumber, LocalDate startDate, LocalDate endDate, DiscountRule discountRule)
    {
        this.requiredItemName = requiredItemName;
        this.requireNumber = requireNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isValid(LocalDate saleDate, List<StoreItem> storeItems)
    {
        if(endDate.isBefore(saleDate)) return false;
        final long matchingItemsCount = storeItems.stream().filter(storeItem -> storeItem.hasSameName(requiredItemName)).count();
        return matchingItemsCount >= requireNumber;
    }
}

package dev.paigewatson.models;

import java.util.List;

public class Discount
{
    private final String requiredItemName;
    private final int requireNumber;

    public Discount(String requiredItemName, int requireNumber, DiscountRule discountRule)
    {
        this.requiredItemName = requiredItemName;
        this.requireNumber = requireNumber;
    }

    public boolean isValid(List<StoreItem> storeItems)
    {
        final long matchingItemsCount = storeItems.stream().filter(storeItem -> storeItem.hasSameName(requiredItemName)).count();
        return matchingItemsCount >= requireNumber;
    }
}
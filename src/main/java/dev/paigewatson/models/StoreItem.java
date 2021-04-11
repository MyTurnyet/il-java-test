package dev.paigewatson.models;

public interface StoreItem
{
    boolean hasSameName(String itemName);

    int AddCostToTotal(int currentTotalCost);

    int amountToSubtractForDiscount(DiscountRule discountRule);
}

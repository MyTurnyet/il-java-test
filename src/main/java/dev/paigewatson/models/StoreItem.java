package dev.paigewatson.models;

public interface StoreItem
{
    int AddCostToTotal(DiscountRule discountRule, int currentTotalCost);

    boolean hasSameName(String itemName);

    int AddCostToTotal(int currentTotalCost);
}

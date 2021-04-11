package dev.paigewatson.models;

public interface StoreItem
{
    boolean hasSameName(String itemName);

    Pennies AddCostToTotal(Pennies currentTotalCost);

    Pennies amountToSubtractForDiscount(DiscountRule discountRule);
}

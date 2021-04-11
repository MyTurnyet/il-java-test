package dev.paigewatson.models;

import dev.paigewatson.models.discounts.DiscountRule;

public interface StoreItem
{
    boolean hasSameName(String itemName);

    Pennies AddCostToTotal(Pennies currentTotalCost);

    Pennies amountToSubtractForDiscount(DiscountRule discountRule);
}

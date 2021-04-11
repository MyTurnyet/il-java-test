package dev.paigewatson.models.store;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.discounts.DiscountRule;

public interface StoreItem
{
    boolean hasSameName(String itemName);

    Pennies AddCostToTotal(Pennies currentTotalCost);

    Pennies amountToSubtractForDiscount(DiscountRule discountRule);
}

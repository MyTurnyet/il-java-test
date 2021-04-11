package dev.paigewatson.models.discounts;

import dev.paigewatson.models.Pennies;

public interface DiscountRule
{
    Pennies discountedAmount(Pennies fullCost);

    boolean matchesItemName(String StoreItemName);
}

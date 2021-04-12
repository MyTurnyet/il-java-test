package dev.paigewatson.models.discounts;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.store.ItemName;

public interface DiscountRule
{
    Pennies discountedAmount(Pennies fullCost);

    boolean matchesItemName(ItemName StoreItemName);
}

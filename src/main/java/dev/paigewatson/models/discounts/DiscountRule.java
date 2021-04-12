package dev.paigewatson.models.discounts;

import dev.paigewatson.models.ItemMatcher;
import dev.paigewatson.models.Pennies;

public interface DiscountRule extends ItemMatcher
{
    Pennies discountedAmount(Pennies fullCost);
}

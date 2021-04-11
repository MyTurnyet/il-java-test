package dev.paigewatson.models;

public interface DiscountRule
{
    Pennies discountedAmount(Pennies fullCost);

    boolean matchesItemName(String StoreItemName);
}

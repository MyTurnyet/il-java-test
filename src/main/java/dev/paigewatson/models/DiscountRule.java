package dev.paigewatson.models;

public interface DiscountRule
{
    int discountedAmount(int fullCost);

    boolean matchesItemName(String StoreItemName);
}

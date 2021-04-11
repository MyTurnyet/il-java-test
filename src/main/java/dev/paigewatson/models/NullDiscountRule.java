package dev.paigewatson.models;

public class NullDiscountRule implements DiscountRule
{
    @Override
    public int discountedAmount(int fullCost)
    {
        return 0;
    }

    @Override
    public boolean matchesItemName(String StoreItemName)
    {
        return false;
    }
}

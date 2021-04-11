package dev.paigewatson.models;

public class DiscountRule
{
    private final String discountItemName;
    private final int discountPercentage;

    public DiscountRule(int discountPercentage, String nameOfItemToDiscount)
    {
        this.discountPercentage = discountPercentage;
        discountItemName = nameOfItemToDiscount;
    }

    public int discountedAmount(int fullCost)
    {
        return (fullCost * discountPercentage) / 100;
    }

    public boolean matchesItemName(String StoreItemName)
    {
        return StoreItemName.equals(discountItemName);
    }
}

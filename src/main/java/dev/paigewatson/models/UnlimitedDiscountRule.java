package dev.paigewatson.models;

public class UnlimitedDiscountRule implements DiscountRule
{
    private final String discountItemName;
    private final int discountPercentage;

    public UnlimitedDiscountRule(int discountPercentage, String nameOfItemToDiscount)
    {
        this.discountPercentage = discountPercentage;
        discountItemName = nameOfItemToDiscount;
    }

    @Override
    public int discountedAmount(int fullCost)
    {
        return (fullCost * discountPercentage) / 100;
    }

    @Override
    public boolean matchesItemName(String StoreItemName)
    {
        return StoreItemName.equals(discountItemName);
    }
}

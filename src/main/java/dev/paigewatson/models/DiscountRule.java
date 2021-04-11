package dev.paigewatson.models;

public class DiscountRule
{
    private final int discountPercentage;

    public DiscountRule(String itemName, int discountPercentage)
    {
        this.discountPercentage = discountPercentage;
    }

    public int discountedAmount(int fullCost)
    {
        return fullCost - (fullCost * discountPercentage) / 100;
    }
}

package dev.paigewatson.models.discounts;

import dev.paigewatson.models.Pennies;

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
    public Pennies discountedAmount(Pennies fullCost)
    {
        return fullCost.percentage(discountPercentage);
//        return (fullCost * discountPercentage) / 100;
    }

    @Override
    public boolean matchesItemName(String StoreItemName)
    {
        return StoreItemName.equals(discountItemName);
    }
}

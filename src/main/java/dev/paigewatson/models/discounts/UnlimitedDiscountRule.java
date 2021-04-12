package dev.paigewatson.models.discounts;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.store.ItemName;

public class UnlimitedDiscountRule implements DiscountRule
{
    private final ItemName discountItemName;
    private final int discountPercentage;

    public UnlimitedDiscountRule(int discountPercentage, ItemName nameOfItemToDiscount)
    {
        this.discountPercentage = discountPercentage;
        discountItemName = nameOfItemToDiscount;
    }

    @Override
    public Pennies amountToBeCredited(Pennies fullCost)
    {
        return fullCost.percentage(discountPercentage);
    }

    @Override
    public boolean matchesItemName(ItemName StoreItemName)
    {
        return StoreItemName.equals(discountItemName);
    }
}

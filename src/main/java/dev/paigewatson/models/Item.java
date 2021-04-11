package dev.paigewatson.models;

import dev.paigewatson.models.discounts.DiscountRule;

public class Item implements StoreItem
{

    public static final String SOUP_NAME = "soup";
    public static final String BREAD_NAME = "bread";
    public static final String APPLE_NAME = "apple";
    public static final String MILK_NAME = "milk";

    private final String itemName;
    private final Pennies costPerUnit;

    public static StoreItem Soup()
    {
        return new Item(SOUP_NAME, new Pennies(65));
    }

    public static StoreItem Bread()
    {
        return new Item(BREAD_NAME, new Pennies(80));

    }

    public static StoreItem Apple()
    {
        return new Item(APPLE_NAME, new Pennies(10));

    }

    public static StoreItem Milk()
    {
        return new Item(MILK_NAME, new Pennies(130));

    }

    private Item(String itemName, Pennies costPerUnit)
    {
        this.itemName = itemName;
        this.costPerUnit = costPerUnit;
    }

    @Override
    public boolean hasSameName(String expectedName)
    {
        return expectedName.equals(itemName);
    }

    @Override
    public Pennies AddCostToTotal(Pennies currentTotalCost)
    {
        return currentTotalCost.add(costPerUnit);
    }

    @Override
    public Pennies amountToSubtractForDiscount(DiscountRule discountRule)
    {
        if (!discountRule.matchesItemName(itemName)) return new Pennies();
        return discountRule.discountedAmount(costPerUnit);
    }
}

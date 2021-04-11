package dev.paigewatson.models;

public class Item implements StoreItem
{

    public static final String SOUP_NAME = "soup";
    public static final String BREAD_NAME = "bread";
    public static final String APPLE_NAME = "apple";
    public static final String MILK_NAME = "milk";

    private final String itemName;
    private final int costPerUnit;

    public static StoreItem Soup()
    {
        return new Item(SOUP_NAME, 65);
    }

    public static StoreItem Bread()
    {
        return new Item(BREAD_NAME,  80);

    }
    public static StoreItem Apple()
    {
        return new Item(APPLE_NAME,  10);

    }
    public static StoreItem Milk()
    {
        return new Item(MILK_NAME, 130);

    }

    private Item(String itemName, int costPerUnit)
    {
        this.itemName = itemName;
        this.costPerUnit = costPerUnit;
    }

    @Override
    public int AddCostToTotal(DiscountRule discountRule, int currentTotalCost)
    {
        return currentTotalCost + discountRule.discountedAmount(costPerUnit);
    }

    @Override
    public boolean hasSameName(String expectedName)
    {
        return expectedName.equals(itemName);
    }

    @Override
    public int AddCostToTotal(int currentTotalCost)
    {
        return currentTotalCost + costPerUnit;
    }
}

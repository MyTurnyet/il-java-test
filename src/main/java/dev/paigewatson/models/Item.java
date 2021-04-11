package dev.paigewatson.models;

public class Item implements StoreItem
{

    private final String itemName;
    private final int costPerUnit;

    public static StoreItem Soup()
    {
        return new Item("soup", 65);
    }

    public static StoreItem Bread()
    {
        return new Item("bread",  80);

    }
    public static StoreItem Apples()
    {
        return new Item("apples",  10);

    }
    public static StoreItem Milk()
    {
        return new Item("milk", 130);

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

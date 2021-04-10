package dev.paigewatson.models;

public class Item implements StoreItem
{

    private final String itemName;
    private final int costPerUnit;

    public static StoreItem Soup()
    {
        return new Item("soup", "tin", 65);
    }

    public static StoreItem Bread()
    {
        return new Item("bread", "loaf", 80);

    }
    public static StoreItem Apples()
    {
        return new Item("apples", "single", 10);

    }
    public static StoreItem Milk()
    {
        return new Item("milk", "bottle", 130);

    }

    private Item(String itemName, String unit, int costPerUnit)
    {
        this.itemName = itemName;
        this.costPerUnit = costPerUnit;
    }

    @Override
    public int AddCostToTotal(int currentTotalCost)
    {
        return currentTotalCost + costPerUnit;
    }

    @Override
    public boolean hasSameName(String expectedName)
    {
        return expectedName.equals(itemName);
    }
}

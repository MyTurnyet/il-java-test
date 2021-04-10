package dev.paigewatson.models;

public class Item implements StoreItem
{

    private final String itemName;

    public static StoreItem Soup()
    {
        return new Item("soup", "tin", 65);
    }

    private Item(String itemName, String unit, int costPerUnit)
    {
        this.itemName = itemName;
    }

    @Override
    public int AddCostToTotal(int currentTotalCost)
    {
        return currentTotalCost + 65;
    }

    @Override
    public boolean hasSameName(String expectedName)
    {
        return expectedName.equals(itemName);
    }
}

package dev.paigewatson.models;

public class Item implements StoreItem
{

    public static StoreItem Soup()
    {
        return new Item("Soup", "tin", 65);
    }

    private Item(String name, String unit, int costPerUnit)
    {
    }

    @Override
    public int AddCostToTotal(int currentTotalCost)
    {
        return currentTotalCost + 65;
    }
}

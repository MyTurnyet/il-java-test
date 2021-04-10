package dev.paigewatson.models;

public class Item implements StoreItem
{

    public Item(String name, String unit, int costPerUnit)
    {
    }
    @Override
    public int AddCostToTotal(int currentTotalCost)
    {
        return currentTotalCost + 65;
    }
}

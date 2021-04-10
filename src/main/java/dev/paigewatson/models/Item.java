package dev.paigewatson.models;

public class Item implements StoreItem
{
    public Item()
    {
    }
    @Override
    public int AddCostToTotal(int currentTotalCost)
    {
        return currentTotalCost + 65;
    }
}

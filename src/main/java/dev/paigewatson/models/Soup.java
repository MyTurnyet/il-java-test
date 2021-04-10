package dev.paigewatson.models;

public class Soup implements StoreItem
{
    public Soup()
    {
    }

    public String getWordingForCount(int count)
    {
        return "1 tin of soup";
    }

    @Override
    public int AddCostToTotal(int currentTotalCost)
    {
        return currentTotalCost + 65;
    }
}

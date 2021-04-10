package dev.paigewatson.models;

public interface StoreItem
{
    int AddCostToTotal(int currentTotalCost);

    boolean hasSameName(String itemName);
}

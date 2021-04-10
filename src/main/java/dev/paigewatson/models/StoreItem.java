package dev.paigewatson.models;

public interface StoreItem
{
    String getWordingForCount(int count);

    int AddCostToTotal(int currentTotalCost);
}

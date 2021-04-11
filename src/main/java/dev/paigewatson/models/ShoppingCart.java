package dev.paigewatson.models;

import java.util.ArrayList;

public class ShoppingCart
{
    private final ArrayList<StoreItem> itemsInCart = new ArrayList<>();

    public void addItem(StoreItem item)
    {
        itemsInCart.add(item);
    }

    public int totalCost()
    {
        int total = 0;
        for (StoreItem storeItem : itemsInCart)
        {
            total = storeItem.AddCostToTotal(total);
        }
        return total;
    }
}

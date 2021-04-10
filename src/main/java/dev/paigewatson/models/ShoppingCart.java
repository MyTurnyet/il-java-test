package dev.paigewatson.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart
{
    private final ArrayList<StoreItem> itemsInCart = new ArrayList<>();

    public int itemCount()
    {
        return itemsInCart.size();
    }

    public void addItem(StoreItem item)
    {
        itemsInCart.add(item);
    }
}

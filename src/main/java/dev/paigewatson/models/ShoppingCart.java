package dev.paigewatson.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart
{
    private final List<StoreItem> itemsInCart = Collections.emptyList();

    public int itemCount()
    {
        return itemsInCart.size();
    }
}

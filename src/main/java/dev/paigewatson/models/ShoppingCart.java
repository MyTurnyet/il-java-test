package dev.paigewatson.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class ShoppingCart
{
    private final ArrayList<StoreItem> itemsInCart = new ArrayList<>();
    private final LocalDate purchaseDate;

    public ShoppingCart()
    {
    this(LocalDate.now());
    }

    public ShoppingCart(LocalDate purchaseDate)
    {

        this.purchaseDate = purchaseDate;
    }

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

    public boolean purchaseDateMatches(LocalDate expectedDate)
    {
        return expectedDate.compareTo(purchaseDate)==0;
    }
}

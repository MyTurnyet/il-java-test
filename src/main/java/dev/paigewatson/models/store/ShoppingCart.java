package dev.paigewatson.models.store;

import dev.paigewatson.models.Pennies;

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

    public Pennies totalCost()
    {
        Pennies totalAmount = new Pennies(0);
        for (StoreItem storeItem : itemsInCart)
        {
           totalAmount =  storeItem.AddCostToTotal(totalAmount);
        }
        return totalAmount;
    }

    public boolean purchaseDateMatches(LocalDate expectedDate)
    {
        return expectedDate.compareTo(purchaseDate)==0;
    }
}

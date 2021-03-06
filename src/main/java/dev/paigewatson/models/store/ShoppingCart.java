package dev.paigewatson.models.store;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.service.io.OutputWriter;

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
            totalAmount = storeItem.addCostToTotal(totalAmount);
        }
        return totalAmount;
    }

    public void writeContentsToOutput(OutputWriter outputWriter)
    {
        outputWriter.writeLine("apple");
    }
}

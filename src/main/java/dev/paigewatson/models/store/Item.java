package dev.paigewatson.models.store;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.discounts.DiscountRule;
import dev.paigewatson.service.io.OutputWriter;

public class Item implements StoreItem
{
    private final ItemName itemName;
    private final Pennies costPerUnit;

    public static StoreItem Soup()
    {
        return new Item(ItemName.Soup, new Pennies(65));
    }

    public static StoreItem Bread()
    {
        return new Item(ItemName.Bread, new Pennies(80));

    }

    public static StoreItem Apple()
    {
        return new Item(ItemName.Apple, new Pennies(10));

    }

    public static StoreItem Milk()
    {
        return new Item(ItemName.Milk, new Pennies(130));

    }

    private Item(ItemName itemName, Pennies costPerUnit)
    {
        this.itemName = itemName;
        this.costPerUnit = costPerUnit;
    }

    @Override
    public boolean hasSameName(ItemName expectedName)
    {
        return expectedName.equals(itemName);
    }

    @Override
    public Pennies AddCostToTotal(Pennies currentTotalCost)
    {
        return currentTotalCost.add(costPerUnit);
    }

    @Override
    public Pennies amountToSubtractForDiscount(DiscountRule discountRule)
    {
        if (!discountRule.matchesItemName(itemName)) return new Pennies();
        return discountRule.discountedAmount(costPerUnit);
    }

    @Override
    public void writeNameToOutput(OutputWriter outputWriter)
    {
        outputWriter.writeLine(itemName.toString());
    }
}

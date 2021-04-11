package dev.paigewatson.models.store;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.discounts.DiscountRule;
import dev.paigewatson.service.io.OutputWriter;

public interface StoreItem
{
    boolean hasSameName(String itemName);

    Pennies AddCostToTotal(Pennies currentTotalCost);

    Pennies amountToSubtractForDiscount(DiscountRule discountRule);

    void writeNameToOutput(OutputWriter outputWriter);
}

package dev.paigewatson.models.store;

import dev.paigewatson.models.ItemMatcher;
import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.discounts.DiscountRule;
import dev.paigewatson.service.io.OutputWriter;

public interface StoreItem extends ItemMatcher
{
//    boolean hasSameName(ItemName itemName);

    Pennies addCostToTotal(Pennies currentTotalCost);

    Pennies amountToBeCreditedForDiscount(DiscountRule discountRule);

    void writeNameToOutput(OutputWriter outputWriter);
}

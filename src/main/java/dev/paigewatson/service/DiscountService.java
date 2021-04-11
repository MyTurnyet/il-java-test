package dev.paigewatson.service;

import dev.paigewatson.models.DiscountRule;
import dev.paigewatson.models.StoreItem;

import java.util.List;

public class DiscountService
{
    private final List<DiscountRule> discountRules;

    public DiscountService(List<DiscountRule> discountRules)
    {
        this.discountRules = discountRules;
    }

    public int applyDiscounts(List<StoreItem> storeItems)
    {
        return storeItems.stream()
                .mapToInt(storeItem -> discountRules.stream()
                        .mapToInt(storeItem::amountToSubtractForDiscount)
                        .sum())
                .sum();
    }
}

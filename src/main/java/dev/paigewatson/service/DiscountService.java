package dev.paigewatson.service;

import dev.paigewatson.models.DiscountRule;
import dev.paigewatson.models.ShoppingCart;

import java.util.List;

public class DiscountService
{
    public DiscountService(List<DiscountRule> discountRules)
    {
    }

    public int applyDiscounts(ShoppingCart shoppingCart)
    {
        return 1;
    }
}

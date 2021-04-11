package dev.paigewatson.service;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.models.StoreItem;
import dev.paigewatson.models.discounts.Discount;

import java.time.LocalDate;
import java.util.List;

public class DiscountService
{
    private final List<Discount> discounts;

    public DiscountService(List<Discount> discounts)
    {
        this.discounts = discounts;
    }

    public Pennies getTotalCreditDiscounts(LocalDate saleDate, List<StoreItem> storeItems)
    {
        Pennies sum = new Pennies();
        for (Discount discount : discounts)
        {
            sum = sum.add(discount.apply(saleDate, storeItems));
        }
        return sum;
    }
}

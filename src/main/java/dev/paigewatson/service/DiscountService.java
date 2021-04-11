package dev.paigewatson.service;

import dev.paigewatson.models.Discount;
import dev.paigewatson.models.StoreItem;

import java.time.LocalDate;
import java.util.List;

public class DiscountService
{
    private final List<Discount> discounts;

    public DiscountService(List<Discount> discounts)
    {
        this.discounts = discounts;
    }

    public int getTotalCreditDiscounts(LocalDate saleDate, List<StoreItem> storeItems)
    {
        int amount = 0;
        for (Discount discount : discounts)
        {
            amount += discount.apply(saleDate, storeItems);
        }
        return amount;
    }
}

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
        return discounts.stream().mapToInt(discount -> discount.apply(saleDate, storeItems)).sum();
    }
}

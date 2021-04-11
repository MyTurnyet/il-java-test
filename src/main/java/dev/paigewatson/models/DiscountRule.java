package dev.paigewatson.models;

import java.time.LocalDateTime;

public class DiscountRule
{
    private final int discountPercentage;

    public DiscountRule(String itemName, int discountPercentage, LocalDateTime discountStart, LocalDateTime discountEnd)
    {
        this.discountPercentage = discountPercentage;
    }

    public int discountedAmount(int fullCost)
    {
        return fullCost - (fullCost * discountPercentage) / 100;
    }

    public boolean isInEffect(LocalDateTime effectiveDate)
    {
        return true;
    }
}

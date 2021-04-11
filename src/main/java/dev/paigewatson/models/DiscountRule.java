package dev.paigewatson.models;

import java.time.LocalDate;

public class DiscountRule
{
    private final String discountItemName;
    private final int discountPercentage;
    private final LocalDate discountStartDate;
    private final LocalDate discountEndDate;

    public DiscountRule(String itemName, int discountPercentage, LocalDate discountStart, LocalDate discountEnd)
    {
        discountItemName = itemName;
        this.discountPercentage = discountPercentage;
        discountStartDate = discountStart;
        discountEndDate = discountEnd;
    }

    public int discountedAmount(int fullCost)
    {
        return fullCost - (fullCost * discountPercentage) / 100;
    }

    public boolean isInEffect(LocalDate effectiveDate)
    {
        return effectiveDate.compareTo(discountStartDate) >= 0 && effectiveDate.compareTo(discountEndDate) <= 0;
    }

    public boolean matchesItemName(String StoreItemName)
    {
        return StoreItemName.equals(discountItemName);
    }
}

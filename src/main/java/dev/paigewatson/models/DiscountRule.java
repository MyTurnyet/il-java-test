package dev.paigewatson.models;

import java.time.LocalDate;

public class DiscountRule
{
    private final String discountItemName;
    private final int discountPercentage;
    private final int requiredItemAmount;
    private final LocalDate discountStartDate;
    private final LocalDate discountEndDate;
    private final String requiredItemName;

    public DiscountRule(String requiredItemName, int requiredItemAmount, LocalDate discountStart, LocalDate discountEnd, int discountPercentage, String nameOfItemToDiscount)
    {
        this.requiredItemName = requiredItemName;
        this.requiredItemAmount = requiredItemAmount;
        discountStartDate = discountStart;
        discountEndDate = discountEnd;
        this.discountPercentage = discountPercentage;
        discountItemName = nameOfItemToDiscount;
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

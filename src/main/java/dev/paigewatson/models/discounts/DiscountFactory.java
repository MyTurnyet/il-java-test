package dev.paigewatson.models.discounts;

import dev.paigewatson.models.store.ItemName;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DiscountFactory
{
    public static Discount applesDiscount()
    {
        final LocalDate startDate = LocalDate.now().plusDays(3);
        final LocalDate endDate = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        final UnlimitedDiscountRule appleRule = new UnlimitedDiscountRule(10, ItemName.Apple);
        return new Discount(ItemName.Apple, 1, startDate, endDate, appleRule);
    }
}

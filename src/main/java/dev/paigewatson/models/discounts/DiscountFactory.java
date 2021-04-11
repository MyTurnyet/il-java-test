package dev.paigewatson.models.discounts;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import static dev.paigewatson.models.store.Item.APPLE_NAME;

public class DiscountFactory
{
    public static Discount applesDiscount()
    {
        final LocalDate startDate = LocalDate.now().plusDays(3);
        final LocalDate endDate = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        final UnlimitedDiscountRule appleRule = new UnlimitedDiscountRule(10, APPLE_NAME);
        return new Discount(APPLE_NAME, 1, startDate, endDate, appleRule);
    }
}

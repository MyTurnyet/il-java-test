package dev.paigewatson.models;

import java.util.Objects;

public class Pennies
{
    private final int baseAmount;


    public Pennies()
    {
        this(0);
    }

    public Pennies(int baseAmount)
    {
        this.baseAmount = baseAmount;
    }

    @Override
    public boolean equals(Object other)
    {
        if (this == other) return true;
        if (!(other instanceof Pennies)) return false;
        Pennies pennies = (Pennies) other;
        return baseAmount == pennies.baseAmount;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(baseAmount);
    }

    public Pennies add(Pennies penniesToAdd)
    {
        return new Pennies(penniesToAdd.baseAmount + this.baseAmount);
    }

    public Pennies percentage(int percentage)
    {
        final int percentageAmount = (baseAmount * percentage) / 100;
        return new Pennies(percentageAmount);
    }
}

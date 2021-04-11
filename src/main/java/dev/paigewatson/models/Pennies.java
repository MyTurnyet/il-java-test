package dev.paigewatson.models;

public class Pennies
{
    private final int baseAmount;

    public Pennies(int baseAmount)
    {
        this.baseAmount = baseAmount;
    }

    public int amount()
    {
        return baseAmount;
    }
}

package dev.paigewatson.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

    @Tag("Unit")
public class PenniesTests
{
    @Test
    public void should_createAmount0()
    {
        //assign
        final Pennies pennies = new Pennies(1);

        //act
        final int amount = pennies.amount();
        //assert
        assertThat(amount).isEqualTo(1);
    }
}

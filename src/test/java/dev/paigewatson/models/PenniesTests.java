package dev.paigewatson.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class PenniesTests
{
    @Test
    public void should_equate()
    {
        //assign
        final Pennies pennies1 = new Pennies();
        final Pennies pennies2 = new Pennies();

        //act
        //assert
        assertThat(pennies1).isEqualTo(pennies2);
    }

}

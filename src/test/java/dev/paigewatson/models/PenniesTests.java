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
    @Test
    public void shouldNot_equate()
    {
        //assign
        final Pennies pennies1 = new Pennies(2);
        final Pennies pennies2 = new Pennies(1);

        //act
        //assert
        assertThat(pennies1).isNotEqualTo(pennies2);
    }

    @Test
    public void should_addPenniesTogether()
    {
        //assign
        final Pennies pennies1 = new Pennies(1);
        final Pennies pennies4 = new Pennies(4);

        //act
        final Pennies penniesTotal = pennies1.add(pennies4);
        //assert
        assertThat(penniesTotal).isEqualTo(new Pennies(5));

    }

}

package dev.paigewatson.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class StoreItemTests
{

    @Test
    public void should_itsCost_andReturn65()
    {
        //assign
        String name = "soup";
        String unit = "tin";
        int costPerUnit = 65;
        final StoreItem soup = new Item(name, unit, costPerUnit);

        //act
        final int total = soup.AddCostToTotal(0);
        //assert
        assertThat(total).isEqualTo(65);
    }

    @Test
    public void should_itsCost_andReturn175()
    {
        //assign
        String name = "soup";
        String unit = "tin";
        int costPerUnit = 65;
        final StoreItem soup = new Item(name, unit, costPerUnit);

        //act
        final int total = soup.AddCostToTotal(110);
        //assert
        assertThat(total).isEqualTo(175);
    }
}

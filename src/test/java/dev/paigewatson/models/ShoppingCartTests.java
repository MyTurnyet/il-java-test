package dev.paigewatson.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class ShoppingCartTests
{
    @Test
    public void should_haveNoItems()
    {
        //assign
        final ShoppingCart shoppingCart = new ShoppingCart();

        //act
        final int itemCount = shoppingCart.itemCount();
        //assert
        assertThat(itemCount).isEqualTo(0);
    }

    @Test
    public void should_addSoup_toTheItemList()
    {
        //assign
        final ShoppingCart shoppingCart = new ShoppingCart();

        //act
        shoppingCart.addItem(Item.Soup());
        //assert
        assertThat(shoppingCart.itemCount()).isEqualTo(1);
    }

    @Test
    public void should_calculateCosts()
    {
        //assign
        final ShoppingCart shoppingCart = new ShoppingCart();

        for (int numberToAdd = 0; numberToAdd < 6; numberToAdd++)
        {
            shoppingCart.addItem(Item.Apples());
        }
        shoppingCart.addItem(Item.Milk());

        //act

        final int totalCost = shoppingCart.totalCost();

        //assert
        assertThat(totalCost).isEqualTo(190);
    }
}

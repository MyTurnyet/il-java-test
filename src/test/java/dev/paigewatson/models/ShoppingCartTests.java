package dev.paigewatson.models;

import org.junit.jupiter.api.Nested;
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
        shoppingCart.addItem(new Soup());
        //assert
        assertThat(shoppingCart.itemCount()).isEqualTo(1);
    }
}

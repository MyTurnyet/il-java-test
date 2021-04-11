package dev.paigewatson.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class ShoppingCartTests
{
    @Test
    public void should_matchPurchaseDate()
    {
        //assign
        LocalDate today = LocalDate.now();
        final ShoppingCart shoppingCart = new ShoppingCart(today);

        //act
        final boolean dateMatches = shoppingCart.purchaseDateMatches(LocalDate.now());
        //assert
        assertThat(dateMatches).isTrue();
    }
    @Test
    public void should_notMatch_PurchaseDate()
    {
        //assign
        LocalDate today = LocalDate.now();
        final ShoppingCart shoppingCart = new ShoppingCart(today);

        //act
        final boolean dateMatches = shoppingCart.purchaseDateMatches(LocalDate.now().plusDays(1));
        //assert
        assertThat(dateMatches).isFalse();
    }

    @Test
    public void should_calculateCosts_6Apples_1Milk()
    {
        //assign
        final ShoppingCart shoppingCart = new ShoppingCart();

        for (int numberToAdd = 0; numberToAdd < 6; numberToAdd++)
        {
            shoppingCart.addItem(Item.Apple());
        }
        shoppingCart.addItem(Item.Milk());

        //act
        final int totalCost = shoppingCart.totalCost();

        //assert
        assertThat(totalCost).isEqualTo(190);
    }

    @Test
    public void should_calculateCosts_2Bread_1Milk()
    {
        //assign
        final ShoppingCart shoppingCart = new ShoppingCart();

        for (int numberToAdd = 0; numberToAdd < 2; numberToAdd++)
        {
            shoppingCart.addItem(Item.Bread());
        }
        shoppingCart.addItem(Item.Milk());

        //act
        final int totalCost = shoppingCart.totalCost();

        //assert
        assertThat(totalCost).isEqualTo(290);
    }
}

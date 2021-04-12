package dev.paigewatson.models.store;

import dev.paigewatson.models.Pennies;
import dev.paigewatson.service.io.CommandLineWriter;
import dev.paigewatson.service.io.OutputWriter;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class ShoppingCartTests
{
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
        final Pennies totalCost = shoppingCart.totalCost();

        //assert
        assertThat(totalCost).isEqualTo(new Pennies(190));
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
        final Pennies totalCost = shoppingCart.totalCost();

        //assert
        assertThat(totalCost).isEqualTo(new Pennies(290));
    }

    @Test
    public void should_writeShoppingCartContentsToCommandLine()
    {
        //assign
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outputStream);
        final OutputWriter commandLineWriter = new CommandLineWriter(printStream);

        final ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(Item.Apple());

        //act
        shoppingCart.writeContentsToOutput(commandLineWriter);
        //assert
        assertThat(outputStream.toString()).isEqualTo("apple\r\n");
    }
}

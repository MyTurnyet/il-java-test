package dev.paigewatson.service.io;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class OutputWriterTests
{
    private String carriageReturn = "\r\n";

    @Test
    public void should_write_toOutputStream()
    {
        //assign
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outputStream);

        final OutputWriter commandLineWriter = new CommandLineWriter(printStream);
        //act
        commandLineWriter.writeLine("FOO!");
        //assert

        assertThat(outputStream.toString()).isEqualTo("FOO!" + carriageReturn);
    }

    @Test
    public void should_writeMenu_toOutputStream()
    {
        //assign
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outputStream);

        final OutputWriter commandLineWriter = new CommandLineWriter(printStream);

        //act
        commandLineWriter.printMenu();
        //assert
        assertThat(outputStream.toString()).isEqualTo(
                getExpectedMenuString()
        );
    }

    public static String getExpectedMenuString()
    {
        String carriageReturn = "\r\n";

        return "Press a number to add an item:" + carriageReturn +
                "1. Apple" + carriageReturn +
                "2. Bread" + carriageReturn +
                "3. Milk" + carriageReturn +
                "4. Soup" + carriageReturn +
                carriageReturn +
                "  OR" + carriageReturn +
                carriageReturn +
                "5: Get a total" + carriageReturn +
                carriageReturn +
                "  OR" + carriageReturn +
                carriageReturn +
                "Press any other button to exit" + carriageReturn;
    }
}

package dev.paigewatson;

import dev.paigewatson.service.InputReader;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class AppTests
{
    @Test
    public void shouldOutput_aString_whenAnInt_passedToScanner()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        final Scanner scanner = new Scanner(inputStream);
        final InputReader inputReader = new InputReader(scanner);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(output);
        final App app = new App(printStream, inputReader);

        //act
        app.run();
        //assert
        assertThat(output.toString()).isEqualTo("you pressed: 1");
    }
    @Test
    public void shouldNotOutput_aString_whenNothing_passedToScanner()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes());
        final Scanner scanner = new Scanner(inputStream);
        final InputReader inputReader = new InputReader(scanner);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(output);
        final App app = new App(printStream, inputReader);

        //act
        app.run();
        //assert
        assertThat(output.toString()).isEqualTo("");
    }
}

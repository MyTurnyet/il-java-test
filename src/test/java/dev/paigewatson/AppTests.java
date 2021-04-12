package dev.paigewatson;

import dev.paigewatson.service.io.CommandLineReader;
import dev.paigewatson.service.io.CommandLineWriter;
import dev.paigewatson.service.io.InputReader;
import dev.paigewatson.service.io.OutputWriter;
import dev.paigewatson.service.io.OutputWriterTests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class AppTests
{
    @Test
    public void shouldOutput_aString_whenAnInt_passedToScanner()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        final InputReader inputReader = new CommandLineReader(inputStream);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(output);
        final OutputWriter outputWriter = new CommandLineWriter(printStream);
        final App app = new App(outputWriter, inputReader);

        //act
        app.run();
        //assert
        assertThat(output.toString()).isEqualTo(OutputWriterTests.getExpectedMenuString() + "you pressed: 1\r\n" +
                "Thank you, Good bye!\r\n");
    }

    @Test
    public void shouldNotOutput_aString_whenNothing_passedToScanner()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(" ".getBytes());
        final InputReader inputReader = new CommandLineReader(inputStream);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(output);
        final OutputWriter outputWriter = new CommandLineWriter(printStream);
        final App app = new App(outputWriter, inputReader);

        //act
        app.run();
        //assert
        assertThat(output.toString()).isEqualTo(OutputWriterTests.getExpectedMenuString() + "Thank you, Good bye!\r\n");
    }

    @Test
    public void shouldOutput_errorMessage_whenNonInt_passedToScanner()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("a".getBytes());
        final InputReader inputReader = new CommandLineReader(inputStream);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(output);
        final OutputWriter outputWriter = new CommandLineWriter(printStream);
        final App app = new App(outputWriter, inputReader);

        //act
        app.run();
        //assert
        assertThat(output.toString()).isEqualTo(OutputWriterTests.getExpectedMenuString() + "Thank you, Good bye!\r\n");
    }
//
//    @Test
//    public void should_waitForInt_fromConsole() throws IOException
//    {
//        //assign
//        final InputStream inputStream = System.in;
//        final InputReader inputReader = new CommandLineReader(inputStream);
//
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        final PrintStream printStream = new PrintStream(output);
//        final OutputWriter outputWriter = new CommandLineWriter(printStream);
//
//        final App app = new App(outputWriter, inputReader);
//
//        //act
//        app.run();
//        //assert
//        assertThat(output.toString()).isEqualTo(OutputWriterTests.getExpectedMenuString());
//        final ByteArrayInputStream consoleInput = new ByteArrayInputStream("1".getBytes());
//
//        System.in.read("1".getBytes());
//    }
}

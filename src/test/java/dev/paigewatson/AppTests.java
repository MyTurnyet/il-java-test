package dev.paigewatson;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class AppTests
{
    @Test
    public void should_take_outputWriterAndReader_inConstructor()
    {
        //assign
        final Scanner scanner = new Scanner(System.in);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(output);
        final App app = new App(printStream, scanner);

        //act
        app.run();
        //assert
        assertThat(output.toString()).isEqualTo("hello world");
    }
}

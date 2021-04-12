package dev.paigewatson.service.io;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@Tag("Unit")
public class InputReaderTests
{

    @Test
    public void shouldNot_validateInput_asInt()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("a".getBytes());
        final InputReader inputReader = new CommandLineReader(inputStream);

        //act
        assertThatThrownBy(() ->
        {
            final int validInteger = inputReader.getNextInteger();
        }).isInstanceOf(InputMismatchException.class);
        //assert
    }

    @Test
    public void should_validateInput_asInt()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("4".getBytes());
        final InputReader inputReader = new CommandLineReader(inputStream);

        //act
        final int validInteger = inputReader.getNextInteger();
        //assert
        assertThat(validInteger).isEqualTo(4);
    }
}

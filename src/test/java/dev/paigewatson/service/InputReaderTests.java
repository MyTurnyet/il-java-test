package dev.paigewatson.service;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Unit")
public class InputReaderTests
{
    @Test
    public void should_returnTrue_whenHasInput()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        final Scanner scanner = new Scanner(inputStream);

        final InputReader inputReader = new InputReader(scanner);

        //act
        final boolean hasInput = inputReader.hasInput();
        //assert
        assertThat(hasInput).isTrue();

    }

    @Test
    public void should_returnFalse_whenNoInput()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes());
        final Scanner scanner = new Scanner(inputStream);

        final InputReader inputReader = new InputReader(scanner);

        //act
        final boolean hasInput = inputReader.hasInput();
        //assert
        assertThat(hasInput).isFalse();
    }

    @Test
    public void shouldNot_validateInput_asInt()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("a".getBytes());
        final InputReader inputReader = new InputReader(inputStream);

        //act
        final boolean validInteger = inputReader.hasValidInteger();
        //assert
        assertThat(validInteger).isFalse();
    }
    @Test
    public void should_validateInput_asInt()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("4".getBytes());
        final InputReader inputReader = new InputReader(inputStream);

        //act
        final boolean validInteger = inputReader.hasValidInteger();
        //assert
        assertThat(validInteger).isTrue();
    }
}

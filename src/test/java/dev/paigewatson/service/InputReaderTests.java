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
    public void should_readInput_asInt()
    {
        //assign
        final ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(inputStream);
        final Scanner scanner = new Scanner(System.in);

        final InputReader inputReader = new InputReader(scanner);

        //act
        final boolean hasInput = inputReader.hasInput();
        //assert
        assertThat(hasInput).isTrue();

    }
}

package dev.paigewatson.service;

import java.io.InputStream;
import java.util.Scanner;

public class CommandLineReader implements InputReader
{
    private final Scanner scanner;

    public CommandLineReader(InputStream inputStream)
    {
        this(new Scanner(inputStream));
    }

    private CommandLineReader(Scanner scanner)
    {
        this.scanner = scanner;
    }

    @Override
    public boolean hasInput()
    {
        return scanner.hasNext();
    }

    @Override
    public boolean hasValidInteger()
    {
        return scanner.hasNextInt();
    }
}

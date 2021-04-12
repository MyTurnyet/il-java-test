package dev.paigewatson.service.io;

import java.io.InputStream;
import java.util.Scanner;

public class CommandLineReader implements InputReader
{
    private final Scanner scanner;

    public CommandLineReader()
    {
        this(System.in);
    }

    public CommandLineReader(InputStream inputStream)
    {
        this(new Scanner(inputStream));
    }

    private CommandLineReader(Scanner scanner)
    {
        this.scanner = scanner;
    }

    @Override
    public int getNextInteger()
    {
        return scanner.nextInt();
    }

}

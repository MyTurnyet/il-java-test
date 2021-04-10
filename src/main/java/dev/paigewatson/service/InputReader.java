package dev.paigewatson.service;

import java.io.InputStream;
import java.util.Scanner;

public class InputReader
{
    private final Scanner scanner;

    public InputReader(InputStream inputStream)
    {
        this(new Scanner(inputStream));
    }

    private InputReader(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public boolean hasInput()
    {
        return scanner.hasNext();
    }

    public boolean hasValidInteger()
    {
        return scanner.hasNextInt();
    }
}

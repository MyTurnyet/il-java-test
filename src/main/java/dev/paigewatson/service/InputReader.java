package dev.paigewatson.service;

import java.util.Scanner;

public class InputReader
{
    private final Scanner scanner;

    public InputReader(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public boolean hasInput()
    {
        return scanner.hasNext();
    }
}

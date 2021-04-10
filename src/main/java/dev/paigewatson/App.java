package dev.paigewatson;

import java.io.PrintStream;
import java.util.Scanner;

public class App
{
    private final PrintStream printStream;
    private final Scanner scanner;

    public App(PrintStream printStream, Scanner scanner)
    {
        this.printStream = printStream;
        this.scanner = scanner;
    }

    public void run()
    {
        final int nextInt = scanner.nextInt();
        printStream.printf("you pressed: %d", nextInt);
    }
}

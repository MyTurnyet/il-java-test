package dev.paigewatson;

import java.io.PrintStream;
import java.util.Scanner;

public class App
{
    private final PrintStream printStream;

    public App(PrintStream printStream, Scanner scanner)
    {
        this.printStream = printStream;
    }

    public void run()
    {
        printStream.print("hello world");
    }
}

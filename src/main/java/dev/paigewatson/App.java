package dev.paigewatson;

import java.io.PrintStream;

public class App
{
    private final PrintStream printStream;

    public App(PrintStream printStream)
    {
        this.printStream = printStream;
    }

    public void run()
    {
        printStream.print("hello world");
    }
}

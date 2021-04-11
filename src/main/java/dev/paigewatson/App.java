package dev.paigewatson;

import dev.paigewatson.service.io.InputReader;

import java.io.PrintStream;

public class App
{
    private final PrintStream printStream;
    private final InputReader inputReader;

    public App(PrintStream printStream, InputReader inputReader)
    {
        this.printStream = printStream;
        this.inputReader = inputReader;
    }

    public void run()
    {
        if (inputReader.hasInput())
        {
            if (inputReader.hasValidInteger())
            {
                printStream.print("you pressed: 1");
            } else
            {
                printStream.print("Please input a number");
            }
        }
    }
}

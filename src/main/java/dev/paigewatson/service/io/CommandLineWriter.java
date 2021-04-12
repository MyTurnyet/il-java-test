package dev.paigewatson.service.io;

import java.io.PrintStream;

public class CommandLineWriter implements OutputWriter
{
    private final PrintStream outputStream;

    public CommandLineWriter()
    {
        this(System.out);
    }

    public CommandLineWriter(PrintStream outputStream)
    {
        this.outputStream = outputStream;
    }

    private void writeLine()
    {
        writeLine("");
    }

    @Override
    public void writeLine(String lineToWrite)
    {
        outputStream.println(lineToWrite);
    }

    @Override
    public void printMenu()
    {
        writeLine("Press a number to add an item:");
        writeLine("1. Apple");
        writeLine("2. Bread");
        writeLine("3. Milk");
        writeLine("4. Soup");
        writeLine();
        writeLine("  OR");
        writeLine();
        writeLine("5: Get a total");
        writeLine();
        writeLine("  OR");
        writeLine();
        writeLine("Press any other button to exit");
    }

}

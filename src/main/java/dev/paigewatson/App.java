package dev.paigewatson;

import dev.paigewatson.service.io.InputReader;
import dev.paigewatson.service.io.OutputWriter;

public class App
{
    private final OutputWriter outputWriter;
    private final InputReader inputReader;

    public App(OutputWriter outputWriter, InputReader inputReader)
    {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void run()
    {
        if (inputReader.hasInput())
        {
            if (inputReader.hasValidInteger())
            {
                outputWriter.writeLine("you pressed: 1");
            } else
            {
                outputWriter.writeLine("Thank you. Good Bye!");
            }
        }
    }
}

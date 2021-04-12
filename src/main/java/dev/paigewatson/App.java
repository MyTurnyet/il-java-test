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
        outputWriter.printMenu();
        try
        {
            int choice = inputReader.getNextInteger();

                outputWriter.writeLine("you pressed: 1");
                outputWriter.writeLine("Thank you, Good bye!");
        } catch (Exception ex){
            outputWriter.writeLine("Thank you, Good bye!");
        }
    }
}

package dev.paigewatson;

import dev.paigewatson.service.io.CommandLineReader;
import dev.paigewatson.service.io.CommandLineWriter;

public class Main
{
    public static void main(String[] args)
    {
        final App app = new App(new CommandLineWriter(), new CommandLineReader());
        app.run();
    }
}

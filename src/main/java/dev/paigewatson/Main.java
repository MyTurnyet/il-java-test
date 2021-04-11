package dev.paigewatson;

import dev.paigewatson.service.io.CommandLineReader;

public class Main
{
    public static void main(String[] args)
    {
        final App app = new App(System.out, new CommandLineReader());
        app.run();
    }
}

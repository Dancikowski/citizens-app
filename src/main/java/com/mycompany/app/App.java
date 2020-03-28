package com.mycompany.app;

import com.mycompany.app.cli.Cli;

import java.io.IOException;
import java.text.ParseException;

public class App 
{
    public static void main( String[] args ) throws  IOException {
        new Cli().createCli();
    }
}

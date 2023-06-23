package utils;

import org.testng.log.TextFormatter;

import java.io.IOException;
import java.util.logging.*;

public class LoggerExample {
    /*LOGGER*/
    //Declare logger
    private static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());


   /* //Set level and log handlers  in console
    static {
        LOGGER.setLevel(Level.FINE);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        LOGGER.addHandler(consoleHandler);
    }
    //Set level and log handlers in file
    static {
        LOGGER.setLevel(Level.ALL);

        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(LoggerExample.class.getSimpleName()+".log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileHandler.setLevel(Level.WARNING);
        //*Set formatter of file*//*
        fileHandler.setFormatter(new SimpleFormatter());
        //fileHandler.setFormatter(new XMLFormatter());

        fileHandler.setFilter(s->true);
        LOGGER.addHandler(fileHandler);
    }*/
    public static void exampleLog(){
        LOGGER.log(Level.SEVERE,"Launching browser");
        LOGGER.log(Level.WARNING,"Ready to Go to homepage");
        LOGGER.log(Level.INFO,"Go to homepage");
        LOGGER.log(Level.CONFIG,"Go to shopping cart");
        LOGGER.log(Level.FINE,"Go to homepage");
        LOGGER.log(Level.FINER,"Go to shopping cart");
        LOGGER.log(Level.FINEST,"Go to shopping cart");
    }
    public static void main (String[] args){
        LoggingUtil.initLogManager();
        exampleLog();
    }
}

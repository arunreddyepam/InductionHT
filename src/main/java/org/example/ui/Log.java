package org.example.ui;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private static final Logger logger = Logger.getLogger(Log.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("ui.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void info(String message){
        logger.log(Level.INFO, message);
    }

    public static void error(String message){
        logger.log(Level.SEVERE, message);
    }
}

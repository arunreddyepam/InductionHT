package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility to get a logger for any class.
 * Usage: Logger log = LoggerUtil.getLogger(MyClass.class);
 */
public class LoggerUtil {

    private LoggerUtil() { }  // prevent instantiation

    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }
}
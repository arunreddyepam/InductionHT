package org.example.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingLevelsDemo {
    private static final Logger logger = LogManager.getLogger(LoggingLevelsDemo.class);

    public static void main(String[] args) {
        logger.trace("TRACE: Most detailed - entering method");
        logger.debug("DEBUG: Debugging info - variable value = 42");
        logger.info("INFO: Test execution started");
        logger.warn("WARN: Element took longer than expected to load");
        logger.error("ERROR: Element not found on page");
        logger.fatal("FATAL: System crashed - cannot continue");

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Exception caught: ", e);
        }
    }
}
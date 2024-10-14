package com.logging.application;

import java.io.IOException;
import java.util.logging.LogManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingApplication01Application {

	// Creates an instance of the logger.
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingApplication01Application.class.getName());

	private static final LogManager logManager = LogManager.getLogManager();

	public static void main(String[] args) throws SecurityException, IOException {

		// Logs an Info level message to the console only if the log is set to info or greater.
		LOGGER.info("The name of the logger is: " + LOGGER.getName());

		// Logs a warning level log.
		LOGGER.warn("An ArrayIndexOutOfBoundsException may occur when using arrays.");

		// An array of size 3
		int[] a = { 1, 2, 3 };

		int index = 4;

		// Logs a config level message
		LOGGER.trace(" The index is set to " + index);

		try {

			System.out.println(a[index]);

		} catch (ArrayIndexOutOfBoundsException ex) {

			// Logs a severe level message.
			LOGGER.error("Error has occured" + LOGGER.getName());

		}

	}
}
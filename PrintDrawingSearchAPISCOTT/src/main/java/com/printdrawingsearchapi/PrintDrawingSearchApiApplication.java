package com.printdrawingsearchapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.printdrawingsearchapi.exceptions.PrintDrawingNotFoundException;

/**
 * Contains the "main" method for starting the PrintDrawingAPI
 */
@SpringBootApplication
public class PrintDrawingSearchApiApplication {

	// Initialize a logger for the class
	private static final Logger logger = LoggerFactory.getLogger(PrintDrawingSearchApiApplication.class.getName());

	// private static final LogManager logManager = LogManager.getLogManager();

	/**
	 * The Main method to start Spring Boot ˚
	 * 
	 * @param args these are command-line arguments
	 * @throws PrintDrawingNotFoundException exception is thrown if print drawing is not found
	 */
	public static void main(String[] args) throws PrintDrawingNotFoundException {
		SpringApplication.run(PrintDrawingSearchApiApplication.class, args);

		logger.trace("Application is starting ................");
	}

}

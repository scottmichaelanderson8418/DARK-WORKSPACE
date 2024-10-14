package com.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.logger.controller.ScottMessageController;

@SpringBootApplication
public class ScottloggerApplication {

    public static void main(String[] args) {
	Logger logger = LoggerFactory.getLogger(ScottMessageController.class.getName());
	logger.trace("main(): Entered......");
	logger.debug("main(): Entered......");

	SpringApplication.run(ScottloggerApplication.class, args);

    }

}

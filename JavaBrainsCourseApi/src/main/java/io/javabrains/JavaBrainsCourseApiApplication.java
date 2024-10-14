package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaBrainsCourseApiApplication {

	public static void main(String[] args) {

		// create a servlet container and host this application in this servlet
		// container
		// SpringApplication.run(class, args)

		SpringApplication.run(JavaBrainsCourseApiApplication.class, args);

	}

}

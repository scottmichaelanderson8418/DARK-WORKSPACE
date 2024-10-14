package com.example.demo;

import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleServletApplication.class, args);

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		tomcat.getConnector();

		Context ctx = tomcat.addContext("", null);
		Wrapper servlet = Tomcat.addServlet(ctx, "myServlet", new MyServletV2());
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/*");

		tomcat.start();

	}

}

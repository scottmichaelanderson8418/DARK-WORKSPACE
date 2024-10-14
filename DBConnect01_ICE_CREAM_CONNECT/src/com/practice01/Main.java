package com.practice01;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// Connection object
		Connection conn;

		try {
			// this will tell us what type of driver we are using
			Class.forName("org.postgresql.Driver");
			// driver --> jdbc
			// url --> postgres://localhost:5432/IceCreamDemo
			// database table --> IceCreamDemo
			// username --> postgres
			// password --> password
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/IceCreamDemo",
					"postgres", "five2one");

		} catch (Exception e) {
			// this will show what line in the sql code the error occurred in
			e.printStackTrace();
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			// this will kill the program
			System.exit(0);
		}

		System.out.println("Connected to the database successfully!");

	}

}

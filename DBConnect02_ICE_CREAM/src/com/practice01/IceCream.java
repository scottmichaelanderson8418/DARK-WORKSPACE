package com.practice01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IceCream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2. Check if the database exist, if so, drop the table

		try {

			/* 1. Create connection to database */
			// this will tell us what type of driver we are using
			Class.forName("org.postgresql.Driver");
			// driver --> jdbc
			// url --> postgres://localhost:5432/IceCreamDemo
			// database table --> IceCreamDemo
			// username --> postgres
			// password --> password
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/IceCreamDemo", "postgres", "five2one");
			System.out.println("Connected to database successfully!!!");

			/* 2. Check if the database exist, if so, drop the table */
			dropTable(conn);

			/* 3. build ( or rebuild) the IceCream table and add rows */
			buildIceCreamTable(conn);

			/* 4. display all of the rows of data from the ice cream table */
			displayAllRows(conn);

			/* 5. calculate the total cost of all of the ice cream in the database table */
			totalIceCreamCost(conn);
			/* 6. close the connection */
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}// end main method

	// drop table method drops existing IceCream Table, in case the database already
	// exists

	public static void dropTable(Connection conn) {

		// message to check for tables
		System.out.println("Checking for existing IceCream table in the IceCreamDemo Database");

		// SQL Code --> must use Try Catch block
		try {
			// statement object
			Statement stmt = conn.createStatement();

			// execute a statement to drop the table

			// use DROP TABLE IF EXISTS to drop a postgres table
			stmt.execute("DROP TABLE IF EXISTS IceCream");

			// print confirmation that the table is dropped
			System.out.println("IceCream table dropped.");

		} catch (Exception e) {
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}// end drop table method

	// method to build our icecream Table
	public static void buildIceCreamTable(Connection conn) {

		System.out.println("Building the iceCream table in the IceCreamDemo Database...");

		// SQL Code --> must use Try Catch block

		try {
			/* 1. Create the table */
			// statement object
			Statement stmt = conn.createStatement();

			stmt.execute("CREATE TABLE IceCream (iceCreamID Serial PRIMARY KEY," +
					"flavor VARCHAR," + "cost DECIMAL);");

			/* 2. Add rows to table */

			stmt.execute("INSERT INTO IceCream (flavor, cost) VALUES ('Vanilla', 0.55);");
			stmt.execute("INSERT INTO IceCream (flavor, cost) VALUES ('Chocolate', 0.60);");
			stmt.execute("INSERT INTO IceCream (flavor, cost) VALUES ('Strawberry', 0.55);");

			System.out.println("Table Created Succussfully.");

		} catch (Exception e) {
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}// end buildIceCreamTable method

	public static void displayAllRows(Connection conn) {

		try {

			// statement object
			Statement stmt = conn.createStatement();
			stmt.execute("SELECT * FROM IceCream");

			// SQL Statement to execute the query
			// note: When we execute the query -> data is returned back and pushed into a
			// result set
			// we need to loop through the result set
			String sqlStatement = "SELECT * FROM IceCream;";

			// Statement to be sent to the DBMS
			// executeQuery puts the results into a list
			ResultSet result = stmt.executeQuery(sqlStatement);

			// Display the results of the query
			while (result.next()) {

				System.out.printf("%d \t %s", result.getInt("iceCreamID"),
						result.getString("flavor"));

				if (result.getString("flavor").length() > 10) {
					System.out.printf("\t\t Cost: $%.2f \n", result.getDouble("cost"));
				} else {
					System.out.printf("\t Cost: $%.2f \n", result.getDouble("cost"));
				}
				// result.getString(countA++);
			}

		} catch (SQLException ex) {
			// will show what type of error & the message returned from the error
			System.out.println("ERROR: " + ex.getMessage());
			System.exit(0);
		}
	}

	public static void totalIceCreamCost(Connection conn) {

		try {
			System.out.print("\nTotal Cost of Ice Cream: ");
			Statement stmt = conn.createStatement();

			String sqlStatement;

			sqlStatement = "SELECT SUM(cost) FROM IceCream";

			// when accessing database aggregates the result set will give you two values
			// "Sum of Cost" : "VALUE"
			ResultSet result = stmt.executeQuery(sqlStatement);

			// System.out.println(result.getString(0));
			result.next();

			// System.out.printf("%s \n", result.getInt(0));

			System.out.println("result.getInt(0)= " + result.getBoolean(0));
			System.out.printf("$%.2f \n ", result.getDouble(1));
			System.out.println("result.getDouble(1) = " + result.getDouble(1));
		} catch (SQLException exx) {
			// TODO Auto-generated catch block
			exx.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

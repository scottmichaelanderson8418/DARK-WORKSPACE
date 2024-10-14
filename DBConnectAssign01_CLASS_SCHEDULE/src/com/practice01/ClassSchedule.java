package com.practice01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			/* 1. Create connection to database */
			// this will tell us what type of driver we are using
			Class.forName("org.postgresql.Driver");
			// driver --> jdbc
			// url --> postgres://localhost:5432/IceCreamDemo
			// database table --> IceCreamDemo
			// username --> postgres
			// password --> password

			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/",
					"postgres", "five2one");

			System.out.println("Connected to ClassSchedule Database successfully!!!");

			/* 2. Check if the table exist, if so, drop the table */
			dropTable(conn);

			/* 3. build ( or rebuild) the IceCream table and add rows */
			buildClassScheduleTable(conn);

			/* 4. display all of the rows of data from the ice cream table */
			displayAllRows(conn);

			/* 5. calculate the total cost of all of the ice cream in the database table */
			totalCreditHours(conn);

			/* 6. close the connection */
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}

	}// end main method

	// drop table method drops existing ClassSchedule Table, in case the database
	// already
	// exists

	public static void dropTable(Connection conn) {

		// check if database exists

		// message to check for tables
		System.out.println(
				"Checking for existing ClassSchedule table in the ClassSchedule Database...");

		// SQL Code --> must use Try Catch block
		try {
			// statement object
			Statement stmt = conn.createStatement();

			// execute a statement to drop the table
			// use DROP TABLE IF EXISTS to drop a postgres table
			stmt.execute("DROP TABLE IF EXISTS ClassSchedule");

			// print confirmation that the table is dropped
			System.out.println("ClassSchedule table dropped....");

		} catch (Exception e) {
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}// end drop table method

	// method to build our ClassSchedule Table

	public static void buildClassScheduleTable(Connection conn) {

		System.out.println("Building the ClassSchedule table in the ClassSchedule Database...");

		// SQL Code --> must use Try Catch block

		try {

			/* 1. Create the table */
			// statement object

			Statement stmt = conn.createStatement();

			stmt.execute("CREATE TABLE ClassSchedule (CourseNumber VARCHAR PRIMARY KEY," +
					"CourseName VARCHAR," + "CreditHours INT);");

			/* 2. Add rows to table */
			stmt.execute(
					"INSERT INTO ClassSchedule (CourseNumber, CourseName, CreditHours) VALUES ('CSC-258-N801', 'JAVA Enterprise Programs', 3);");
			stmt.execute(
					"INSERT INTO ClassSchedule (CourseNumber, CourseName, CreditHours) VALUES ('CSC-284-N801', 'Emerging Comp Prog Tech', 3);");

			System.out.println("Table Created Succussfully....");

		} catch (Exception e) {
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}// end buildIceCreamTable method

	// Method to Display All Rows
	public static void displayAllRows(Connection conn) {

		try {

			ResultSet result = getResultSet(conn);

			ResultSetMetaData metaData = result.getMetaData();

			int columnCount = metaData.getColumnCount();
			boolean booLargeFormat = false;

			while (result.next()) {

				if (result.getString("CourseNumber").length() > 10 ||
						result.getString("CourseName").length() > 10) {

					booLargeFormat = true;
				}
			}

			for (int i = 1; i < columnCount + 1; i++) {

				if (!booLargeFormat) {

					System.out.printf("%s \t ", metaData.getColumnName(i).toUpperCase());
				} else {

					System.out.printf("%-30s \t ", metaData.getColumnName(i).toUpperCase());
				}
			}

			result = getResultSet(conn);

			// Display the results of the query
			while (result.next()) {

				if (!booLargeFormat) {

					System.out.printf("%s \t %s \t %d \n", result.getString("CourseNumber"),
							result.getString("CourseName"), result.getInt("CreditHours"));

				} else {

					System.out.printf("%-30s \t %-30s \t %d \n", result.getString("CourseNumber"),
							result.getString("CourseName"), result.getInt("CreditHours"));

				}
			}

		} catch (SQLException ex) {
			// will show what type of error & the message returned from the error
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(0);
		}
	}

	// Create a new ResultSet instance
	public static ResultSet getResultSet(Connection conn) {

		ResultSet result = null;
		try {
			System.out.println();
			// statement object
			Statement stmt = conn.createStatement();
			stmt.execute("SELECT * FROM ClassSchedule");

			// SQL Statement to execute the query
			// note: When we execute the query -> data is returned back and pushed into a
			// result set
			// we need to loop through the result set
			String sqlStatement = "SELECT * FROM ClassSchedule;";

			// Statement to be sent to the DBMS
			// executeQuery puts the results into a list

			result = stmt.executeQuery(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	// Method to Display Total Credit Hours
	public static void totalCreditHours(Connection conn) {

		try {
			System.out.print("\nTotal Credit Hours: ");
			Statement stmt = conn.createStatement();

			String sqlStatement;

			sqlStatement = "SELECT SUM(CreditHours) FROM ClassSchedule";

			// when accessing database aggregates the result set will give you two values
			// "Sum of Cost" : "VALUE"
			ResultSet result = stmt.executeQuery(sqlStatement);

			// System.out.println(result.getString(0));
			result.next();

			// System.out.printf("%s \n", result.getInt(0));
			System.out.printf("%d \n ", result.getInt(1));

		} catch (SQLException exx) {
			// TODO Auto-generated catch block
			exx.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

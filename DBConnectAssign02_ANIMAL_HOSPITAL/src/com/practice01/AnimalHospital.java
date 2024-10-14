package com.practice01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalHospital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String tableName = "";
			/* 1. Create connection to database */
			// this will tell us what type of driver we are using
			Class.forName("org.postgresql.Driver");

			// creates connection to "AnimalHospital" Database
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/AnimalHospital", "postgres", "five2one");

			System.out.println("Connected to AnimalHospital Database successfully!!!");

			/* 2. Check if the table exist, if so, drop the table */
			dropTable(conn);

			/* 3. build ( or rebuild) the AnimalHospital table and add rows */
			buildAnimalHospitalTables(conn);

			/* 4. Display All Tables */

			displayPetTable(conn);

			displayServicesTable(conn);

			displayVisitsTable(conn);

			/* 5. Calculate Query #01 and show result set */
			calculateQuery01(conn);

			/* 6. Calculate Query #02 and show result set */
			calculateQuery02(conn);

			/* 7. close the connection */
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}

	}// end main method

	// drop table method drops existing AnimalHospital Tables, in case the database
	// already exists

	public static void dropTable(Connection conn) {

		// check if database exists

		// message to check for tables
		System.out.println(
				"Checking for existing AnimalHospital table in the AnimalHospital Database...\n");

		// SQL Code --> must use Try Catch block
		try {
			// statement object
			Statement stmt = conn.createStatement();

			// execute a statement to drop the table
			// use DROP TABLE IF EXISTS to drop a postgres table
			stmt.execute("DROP TABLE IF EXISTS PET CASCADE");
			stmt.execute("DROP TABLE IF EXISTS SERVICES CASCADE");
			stmt.execute("DROP TABLE IF EXISTS VISITS CASCADE");

			// print confirmation that the table is dropped
			System.out.println("AnimalHospital table dropped....");

		} catch (Exception e) {
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}// end drop table method

	// method to build our AnimalHospital Table

	public static void buildAnimalHospitalTables(Connection conn) {

		System.out.println("Building the AnimalHospital tables in the AnimalHospital Database...");

		// SQL Code --> must use Try Catch block

		try {

			System.out.println("Attemping to create tables...");
			/* 1. Create the tables */
			// statement object

			Statement stmt = conn.createStatement();
			/* Create AnimalHospital Table */

			stmt.execute("CREATE TABLE PET (\r\n" + "	petID VARCHAR PRIMARY KEY,\r\n" +
					"	petName VARCHAR,\r\n" + "	petType VARCHAR,\r\n" + "	petAge INT,\r\n" +
					"	ownerName VARCHAR\r\n" + ");");
			/* Create Services Table */
			stmt.execute("CREATE TABLE SERVICES (\r\n" + "	serviceID VARCHAR PRIMARY KEY,\r\n" +
					"	serviceName VARCHAR,\r\n" + "	serviceCost DECIMAL\r\n" + ");");
			/* Create VISITS Table */
			stmt.execute("CREATE TABLE VISITS (\r\n" + "	visitID VARCHAR PRIMARY KEY,\r\n" +
					"	petID VARCHAR,\r\n" + "	serviceID VARCHAR,\r\n" +
					"	visitDate VARCHAR,\r\n" +
					"	FOREIGN KEY (petID) REFERENCES PET(petID),\r\n" +
					"	FOREIGN KEY (serviceID) REFERENCES SERVICES(serviceID)\r\n" + ");");

			System.out.println("Created all tables successfully!!!");

			/* 2. Add rows to table */

			System.out.println("Attempting to insert values into tables...");
			/* Add rows to "AnimalHospital" table */
			stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES" +
					"('a0001', 'Ribbles', 'cat', 3, 'Jimmy'),\r\n" +
					"('a0002', 'Jerome', 'dog', 7, 'Tony'),\r\n" +
					"('a0003', 'Rocky', 'dog', 10, 'Tony'),\r\n" +
					"('a0004', 'Goldie', 'fish', 1, 'Terry'),\r\n" +
					"('a0005', 'Hammy', 'hamster', 1, 'Jimmy'),\r\n" +
					"('a0006', 'Swims', 'fish', 2, 'Tony'),\r\n" +
					"('a0007', 'Star', 'cat', 8, 'Lydia'),\r\n" +
					"('a0008', 'Party Supplies', 'dog', 7, 'Brenda'),\r\n" +
					"('a0009', 'Ralph', 'turtle', 2, 'April'),\r\n" +
					"('a0010', 'Leo', 'turtle', 3, 'April'),\r\n" +
					"('a0011', 'Donny', 'turtle', 2, 'April'),\r\n" +
					"('a0012', 'Mikey', 'turtle', 2, 'April'),\r\n" +
					"('a0013', 'Ace', 'bird', 6, 'Paige'),\r\n" +
					"('a0014', 'Lizzy', 'lizard', 6, 'Elizabeth'),\r\n" +
					"('a0015', 'Bishop', 'dog', 8, 'Julius'),\r\n" +
					"('a0016', 'Slizz', 'snake', 6, 'Julius')");
			/* Add rows to "SERVICES" table */
			stmt.execute("INSERT INTO SERVICES (serviceID, serviceName, serviceCost) VALUES\r\n" +
					"('s0001', 'Check Up', 25.00),\r\n" + "('s0002', 'Annual Shots', 50.00),\r\n" +
					"('s0003', 'Buy Medicine', 10.00),\r\n" +
					"('s0004', 'Minor Surgery', 250.00),\r\n" +
					"('s0005', 'Major Surgery', 1000.00),\r\n" +
					"('s0006', 'Physical Therapy Session', 25.00),\r\n" +
					"('s0007', 'Grooming', 80.00);");
			/* Add rows to "VISITS" table */
			stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES \r\n" +
					"('v0001', 'a0002', 's0001', '01-05-2022'),\r\n" +
					"('v0002', 'a0001', 's0001', '01-06-2022'),\r\n" +
					"('v0003', 'a0003', 's0001', '01-06-2022'),\r\n" +
					"('v0004', 'a0004', 's0001', '01-07-2022'),\r\n" +
					"('v0005', 'a0005', 's0001', '01-07-2022'),\r\n" +
					"('v0006', 'a0006', 's0001', '01-07-2022'),\r\n" +
					"('v0007', 'a0007', 's0001', '01-07-2022'),\r\n" +
					"('v0008', 'a0008', 's0001', '01-07-2022'),\r\n" +
					"('v0009', 'a0009', 's0001', '01-07-2022'),\r\n" +
					"('v0010', 'a0005', 's0007', '01-10-2022'),\r\n" +
					"('v0011', 'a0015', 's0001', '01-09-2022'),\r\n" +
					"('v0012', 'a0014', 's0001', '01-09-2022'),\r\n" +
					"('v0013', 'a0015', 's0002', '01-09-2022'),\r\n" +
					"('v0014', 'a0014', 's0002', '01-09-2022'),\r\n" +
					"('v0015', 'a0015', 's0004', '01-22-2022'),\r\n" +
					"('v0016', 'a0014', 's0005', '01-24-2022');");

			System.out.println("Values inserted  Succussfully!!!");

		} catch (SQLException ee) {
			ee.printStackTrace();
		}

		catch (Exception e) {
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}// end buildAnimalHospitalTables method

	// Method to Display All Rows
	public static void displayPetTable(Connection conn) {
		String tableName = "PET";
		try {
			System.out.println("\nAttempting to display " + tableName + " table...");

			System.out.print("\n************ " + tableName + "  TABLE ************");

			ResultSet result = getResultSet(conn, tableName);

			ResultSetMetaData metaData = result.getMetaData();

			int columnCount = metaData.getColumnCount();

			boolean booLargeFormat = false;

			while (result.next()) {

				if (result.getString("petID").length() > 10 ||
						result.getString("petName").length() > 10 ||
						result.getString("petType").length() > 10 ||
						result.getString("petAge").length() > 10 ||
						result.getString("ownerName").length() > 10) {

					booLargeFormat = true;
				}
			}
			// print the column names to the console

			for (int i = 1; i < columnCount + 1; i++) {

				if (!booLargeFormat) {

					System.out.printf("%-30s \t ", metaData.getColumnName(i).toUpperCase());
				} else {

					System.out.printf("%-30s \t\t ", metaData.getColumnName(i).toUpperCase());
				}
			}

			result = getResultSet(conn, tableName);

			// Display the results of the query
			while (result.next()) {

				if (!booLargeFormat) {

					System.out.printf("%-30S \t %-30S \t %-30S \t %-30d \t %-30S\n",
							result.getString("petID"), result.getString("petName"),
							result.getString("petType"), result.getInt("petAge"),
							result.getString("ownerName"));

				} else {

					System.out.printf("%-30S \t\t %-30S \t\t %-30S \t\t %-30d \t\t %-30S\n",
							result.getString("petID"), result.getString("petName"),
							result.getString("petType"), result.getInt("petAge"),
							result.getString("ownerName"));

				}

			}
			System.out.println("Successfully displayed " + tableName + " Table!!!");

		} catch (SQLException ex) {
			// will show what type of error & the message returned from the error
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(0);
		}
	}

	// Method to Display Services Table
	public static void displayServicesTable(Connection conn) {
		String tableName = "SERVICES";
		try {

			System.out.println("\nAttempting to display " + tableName + " table...");
			System.out.print("\n************ " + tableName + "  TABLE ************");

			ResultSet result = getResultSet(conn, tableName);

			ResultSetMetaData metaData = result.getMetaData();

			int columnCount = metaData.getColumnCount();

			boolean booLargeFormat = false;

			while (result.next()) {

				if (result.getString("serviceID").length() > 10 ||
						result.getString("serviceName").length() > 10 ||
						result.getString("serviceCost").length() > 10) {

					booLargeFormat = true;
				}
			}
			// print the column names to the console

			for (int i = 1; i < columnCount + 1; i++) {

				if (!booLargeFormat) {

					System.out.printf("%-30s \t ", metaData.getColumnName(i).toUpperCase());
				} else {

					System.out.printf("%-30s \t\t ", metaData.getColumnName(i).toUpperCase());
				}
			}

			result = getResultSet(conn, tableName);

			// Display the results of the query
			while (result.next()) {

				if (!booLargeFormat) {

					System.out.printf("%-30S \t %-30S \t %-30.2f", result.getString("serviceID"),
							result.getString("serviceName"), result.getDouble("serviceCost"));

				} else {

					System.out.printf("%-30S \t\t %-30S \t\t %-10.2f\n",
							result.getString("serviceID"), result.getString("serviceName"),
							result.getDouble("serviceCost"));

				}

			}
			System.out.println("Successfully displayed " + tableName + " Table!!!");

		} catch (SQLException ex) {
			// will show what type of error & the message returned from the error
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(0);
		}
	}

	// Method to Display Services Table
	public static void displayVisitsTable(Connection conn) {
		String tableName = "VISITS";
		try {

			System.out.println("\nAttempting to display " + tableName + " table...");
			System.out.print("\n************ " + tableName + "  TABLE ************");
			ResultSet result = getResultSet(conn, tableName);

			ResultSetMetaData metaData = result.getMetaData();

			int columnCount = metaData.getColumnCount();

			boolean booLargeFormat = false;

			while (result.next()) {

				if (result.getString("visitID").length() > 10 ||
						result.getString("petId").length() > 10 ||
						result.getString("serviceID").length() > 10 ||
						result.getString("visitDate").length() > 10) {

					booLargeFormat = true;
				}
			}
			// print the column names to the console

			for (int i = 1; i < columnCount + 1; i++) {

				if (!booLargeFormat) {

					System.out.printf("%-30s \t ", metaData.getColumnName(i).toUpperCase());
				} else {

					System.out.printf("%-30s \t\t ", metaData.getColumnName(i).toUpperCase());
				}
			}

			result = getResultSet(conn, tableName);

			// Display the results of the query
			while (result.next()) {

				if (!booLargeFormat) {

					System.out.printf("%-30S \t %-30S \t %-30S \t %-30S\n",
							result.getString("visitID"), result.getString("petID"),
							result.getString("serviceID"), result.getString("visitDate"));

				} else {

					System.out.printf("%-30S \t\t %-30S \t\t %-30S \t\t %-30S\n",
							result.getString("visitID"), result.getString("petID"),
							result.getString("serviceID"), result.getString("visitDate"));

				}

			}
			System.out.println("Successfully displayed " + tableName + " Table!!!");

		} catch (SQLException ex) {
			// will show what type of error & the message returned from the error
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(0);
		}
	}

	// Create a new ResultSet
	public static ResultSet getResultSet(Connection conn, String name) {

		ResultSet result = null;

		try {
			System.out.println();
			// statement object
			Statement stmt = conn.createStatement();

			String temp = "SELECT * FROM " + name + ";";
			stmt.execute(temp);

			// SQL Statement to execute the query
			// note: When we execute the query -> data is returned back and pushed into a
			// result set
			// we need to loop through the result set
			String sqlStatement = temp;

			// Statement to be sent to the DBMS
			// executeQuery puts the results into a list

			result = stmt.executeQuery(sqlStatement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	// Method to calculate query #01
	public static void calculateQuery01(Connection conn) {

		try {
			System.out.println("\n");
			System.out.println("************ Query #01 Table ************");
			System.out.printf("%-30S", "petName");
			System.out.printf("%-30S", "COUNT");
			Statement stmt = conn.createStatement();

			String sqlStatement;

			sqlStatement = "SELECT pet.petName, COUNT(services.serviceID)\r\n" + "FROM PET\r\n" +
					"JOIN VISITS\r\n" + "ON pet.petID = visits.petID\r\n" + "JOIN SERVICES\r\n" +
					"ON services.serviceID = visits.serviceID\r\n" + "GROUP BY pet.petname\r\n" +
					"ORDER BY COUNT(services.serviceID) DESC\r\n" + "LIMIT 3;";

			// when accessing database aggregates the result set will give you two values
			// "Sum of Cost" : "VALUE"
			ResultSet result = stmt.executeQuery(sqlStatement);

			// System.out.println(result.getString(0));
			result.next();
			System.out.println();
			System.out.printf("%-30S", result.getString(1));
			System.out.printf("%-30d\n", result.getInt(2));
			result.next();
			System.out.printf("%-30S", result.getString(1));
			System.out.printf("%-30d\n", result.getInt(2));
			result.next();
			System.out.printf("%-30S", result.getString(1));
			System.out.printf("%-30d\n", result.getInt(2));

		} catch (SQLException exx) {
			// TODO Auto-generated catch block
			exx.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Method to calculate query #02
	public static void calculateQuery02(Connection conn) {

		try {
			System.out.println("\n");
			System.out.println("************ Query #02 Table ************");
			System.out.printf("%-30S", "petName");
			System.out.printf("%-30S", "COUNT");
			Statement stmt = conn.createStatement();

			String sqlStatement;

			sqlStatement = "SELECT pet.petName, SUM(services.serviceCost)\r\n" + "FROM PET\r\n" +
					"JOIN VISITS\r\n" + "ON pet.petID = visits.petID\r\n" + "JOIN SERVICES\r\n" +
					"ON services.serviceID = visits.serviceID\r\n" + "GROUP BY pet.petname\r\n" +
					"ORDER BY SUM(services.serviceCost) DESC\r\n" + "LIMIT 3;";

			// when accessing database aggregates the result set will give you two values
			// "Sum of Cost" : "VALUE"
			ResultSet result = stmt.executeQuery(sqlStatement);

			// System.out.println(result.getString(0));
			result.next();
			System.out.println();
			System.out.printf("%-30S", result.getString(1));
			System.out.printf("%-30d\n", result.getInt(2));
			result.next();
			System.out.printf("%-30S", result.getString(1));
			System.out.printf("%-30d\n", result.getInt(2));
			result.next();
			System.out.printf("%-30S", result.getString(1));
			System.out.printf("%-30d\n", result.getInt(2));

		} catch (SQLException exx) {
			// TODO Auto-generated catch block
			exx.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

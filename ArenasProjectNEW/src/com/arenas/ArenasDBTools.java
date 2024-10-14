package com.arenas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ArenasDBTools {
	public static final Scanner SCANNER = new Scanner(System.in);

	// ------------------------------------------------------------------------------------
	// Method to build the tables
	public static void buildDatabaseTables(Connection connB, ArrayList<Arena> OBJECT_LIST_NAME) {

		// System.out.println("Attemping to build the " + VariablesFinal.TABLE_NAME +
		// " table in the " + VariablesFinal.DATABASE_NAME + " Database...");

		// System.out.println("Press Enter");

		// // DataTools.pressEnter();

		// SQL Code --> must use Try Catch block
		try {
			// System.out.println("Attemping to create tables...");

			// Create the tables
			Statement stmt = connB.createStatement();

			stmt.execute("CREATE TABLE arenas(Venue CHAR(45) primary key," +
					"City CHAR(15), State CHAR(15), MaxCapacity INT, YearOpened INT, TeamName CHAR(30), Sport CHAR(10), LEAGUE CHAR(15));");
			// System.out.println("Created all tables successfully!!!");

			// Add rows to table
			// System.out.println("Attempting to insert values into tables...");

			// OBJECT_LIST_NAME.get(0).getXlsxPath();

			int countA = 0;

			int number = OBJECT_LIST_NAME.size();

			for (int i = 0; i < number; i++) {

				StringBuilder sb = new StringBuilder();

				sb.append(
						"INSERT INTO arenas(Venue, City, State, MaxCapacity, YearOpened, TeamName, Sport, League) ");

				sb.append("VALUES ");
				countA++;

				countA++;
				sb.append("('" + OBJECT_LIST_NAME.get(i).getVenueName() + "', ");
				sb.append("'" + OBJECT_LIST_NAME.get(i).getCity() + "', ");
				sb.append("'" + OBJECT_LIST_NAME.get(i).getState() + "', ");
				sb.append("'" + OBJECT_LIST_NAME.get(i).getMaxCapacity() + "', ");
				sb.append("'" + OBJECT_LIST_NAME.get(i).getYearOpened() + "', ");
				sb.append("'" + OBJECT_LIST_NAME.get(i).getTeam().getTeamName() + "', ");
				sb.append("'" + OBJECT_LIST_NAME.get(i).getTeam().getSport() + "', ");
				sb.append("'" + OBJECT_LIST_NAME.get(i).getTeam().getLeague() + "'); ");

				stmt.execute(sb.toString());

			}

			// System.out.println("PRINTING OUT sb list---->");
			// System.out.println("Press Enter");
			// System.out.println("Press Enter");
			// DataTools.pressEnter();

			System.out.println("Arena table created.");

		} catch (SQLException ee) {
			ee.printStackTrace();
		}

		catch (Exception e) {
			// will show what type of error & the message returned from the
			// error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static void createDatabase(Connection conn) {

		// check if database exists

		// message to check for tables
		// System.out
		// .println("Attempting to create " + VariablesFinal.DATABASE_NAME + "
		// Database...\n");
		// System.out.println("Press Enter");
		// DataTools.pressEnter();
		// SQL Code --> must use Try Catch block
		try {
			// statement object
			Statement stmt = conn.createStatement();

			stmt.execute("CREATE DATABASE " + VariablesFinal.DATABASE_NAME);

			// print confirmation that the table is dropped
			// System.out.println(VariablesFinal.DATABASE_NAME + " database created!!!");

		} catch (SQLException ee) {
			ee.printStackTrace();
		}

		catch (Exception e) {
			// will show what type of error & the message returned from the
			// error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}

	public static Connection createDatabaseConnectionA(ArrayList<Arena> OBJECT_LIST_NAME) {

		try {

			// System.out.println("OBJECT_LIST_NAME.size() = " + OBJECT_LIST_NAME.size());

			// Create connection to database

			// this will tell us what type of driver we are using
			Class.forName("org.postgresql.Driver");

			// creates connection to "AnimalHospital" Database
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres", "postgres", "five2one");

			// System.out.println("Connected to database successfully!!!");

			// System.out.println(
			// "Connected to jdbc:postgresql://localhost:5432/postgres successfully!!!\n");

			return conn;

		} catch (SQLException ee) {
			ee.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
			// will show what type of error & the message returned from the
			// error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}

		return null;

	}

	public static Connection createDatabaseConnectionB(ArrayList<Arena> OBJECT_LIST_NAME) {

		try {

			// System.out.println("OBJECT_LIST_NAME.size() = " + OBJECT_LIST_NAME.size());

			// Create connection to database
			// this will tell us what type of driver we are using
			Class.forName("org.postgresql.Driver");

			// creates connection to "AnimalHospital" Database

			Connection connB = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/arenasdb", "postgres", "five2one");
			// Connection conn = DriverManager.getConnection(
			// "jdbc:postgresql://localhost:5432/" + VariablesFinal.DATABASE_NAME,
			// "postgres",
			// "five2one");
			// System.out.println("Connected to database successfully!!!");
			//
			// System.out.println("Connected to jdbc:postgresql://localhost:5432/" +
			// VariablesFinal.DATABASE_NAME + " successfully!!!\n");

			return connB;

		} catch (SQLException ee) {
			ee.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
			// will show what type of error & the message returned from the
			// error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}

		return null;

	}

	// -------------------------------------------------------------------------------------
	// Method to Delete the existing database
	public static void deleteDatabase(Connection conn) {

		// check if database exists

		// SQL Code --> must use Try Catch block
		try {
			// statement object
			Statement stmt = conn.createStatement();

			// execute a statement to drop the table
			// use DROP TABLE IF EXISTS to drop a postgres table
			ResultSet resultSet = stmt
					.executeQuery("SELECT EXISTS(SELECT 1 FROM pg_database WHERE datname='" +
							VariablesFinal.DATABASE_NAME + "');");

			resultSet.next();

			boolean booA = resultSet.getBoolean(1);

			if (booA) {
				// System.out.println(VariablesFinal.DATABASE_NAME + " database is found !!!");

				stmt.execute("DROP DATABASE \"" + VariablesFinal.DATABASE_NAME + "\";");

				// System.out.println(VariablesFinal.DATABASE_NAME + " database is deleted!!!");

			}

		} catch (SQLException ee) {
			ee.printStackTrace();

		} catch (Exception e) {
			// will show what type of error & the message returned from the
			// error
			e.printStackTrace();
			System.out.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}

		// System.out.println("Press Enter");
		// DataTools.pressEnter();

	}

	// -------------------------------------------------------------------------------
	// drop table method drops existing ArenasDB Tables, in case the database
	// already exists
	public static void dropTable(Connection connB) {
		// boolean value to check for existence of "arenas" table
		boolean tableExists = false;
		try {

			// creating a statement object
			Statement stmt = connB.createStatement();

			// Create a ResultSet Object to receive the boolean value
			ResultSet rs = stmt.executeQuery(
					"SELECT EXISTS (SELECT 1 FROM pg_catalog.pg_tables WHERE schemaname = 'public' AND tablename = 'arenas');");

			while (rs.next()) {

				tableExists = rs.getBoolean(1);
			}

			// if table exists then drop the table
			if (tableExists) {

				stmt.execute("DROP TABLE IF EXISTS arenas CASCADE");
				System.out.println("Arena table dropped.");

			}

		} catch (SQLException ee) {
			ee.printStackTrace();
		} catch (Exception e) {
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}

}
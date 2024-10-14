package com.arenas.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.arenas.models.Arena;

@Service
public class CreateArenasDB {

	public static Scanner scanner = new Scanner(System.in);

	public void createArenasDB(ArrayList<Arena> arenasList) {

		try {

			// ArrayList<AniloxDrawing> aniloxDrawingList =
			// DrawingManager.getDrawings();

			// System.out.println("SIZE = " + aniloxDrawingList.size());
			// String tableName = "";
			// /* 1. Create connection to database */
			// // this will tell us what type of driver we are using
			// Class.forName("org.postgresql.Driver");
			//
			// // creates connection to "AnimalHospital" Database
			// Connection conn = DriverManager.getConnection(
			// "jdbc:postgresql://localhost:5432/PrintSearch", "postgres", "five2one");
			// System.out.println("Connected to database successfully!!!");
			//
			// System.out.println(
			// "Connected to jdbc:postgresql://localhost:5432/printsearch successfully!!!");

			/* 2. Check if the table exist, if so, drop the table */

			// deleteDatabase(conn);
			System.out.println();
			dropTable(conn);
			/* Create Database */

			// createDatabase(conn);

			/* 3. build ( or rebuild) the AnimalHospital table and add rows */
			buildPrintSearchDatabaseTables(conn, arenasList);

			/* 4. Display All Tables */

			/* 7. close the connection */
			conn.close();

		} catch (SQLException ee) {
			ee.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
			// will show what type of error & the message returned from the
			// error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}

	}

	// -----------------------------------------------------------------------------------------------------------
	// drop table method drops existing AnimalHospital Tables, in case the
	// database
	// already exists
	public static void dropTable(Connection conn) {

		try {

			System.out.println("Attemping to drop PrintDrawings table");
			System.out.println("Press Enter");
			pressEnter();
			// statement object
			Statement stmt = conn.createStatement();

			// execute a statement to drop the table
			// use DROP TABLE IF EXISTS to drop a postgres table

			if (stmt.execute("DROP TABLE IF EXISTS PrintDrawings CASCADE")) {
				System.out.println("PrintDrawings table dropped....");
			} else {

				System.out.println("PrintDrawing table does not exists...");
			}

		} catch (SQLException ee) {
			ee.printStackTrace();
		} catch (Exception e) {
			// will show what type of error & the message returned from the
			// error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Press Enter");
		pressEnter();
		System.out.println("PrintDrawings TABLES dropped....");

	}
	// -----------------------------------------------------------------------------------------------------------
	// press enter to pause the code

	public static void pressEnter() {

		scanner.nextLine();

	}

	// -----------------------------------------------------------------------------------------------------------
	// Method to Delete the existing database
	public static void deleteDatabase(Connection conn) {

		// check if database exists

		// message to check for tables
		System.out.println("\nChecking to see if 'PrintSearch' Database exist...\n");

		System.out.println("Press Enter");
		pressEnter();
		// SQL Code --> must use Try Catch block
		try {
			// statement object
			Statement stmt = conn.createStatement();

			// execute a statement to drop the table
			// use DROP TABLE IF EXISTS to drop a postgres table
			ResultSet resultSet = stmt.executeQuery(
					"SELECT EXISTS(SELECT 1 FROM pg_database WHERE datname='printsearch');");

			resultSet.next();

			boolean booA = resultSet.getBoolean(1);

			if (booA) {
				System.out.println("PrintSearch database is found !!!");
				System.out.println("PrintSearch database is deleted!!!");

			} else {
				System.out.println("PrintSearch database does not exists...");
			}
			System.out.println("Press Enter");
			pressEnter();
		} catch (SQLException ee) {
			ee.printStackTrace();

		} catch (Exception e) {
			// will show what type of error & the message returned from the
			// error
			e.printStackTrace();
			System.out.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}

		System.out.println("Press Enter");
		pressEnter();

	}// end drop table method
		// -----------------------------------------------------------------------------------------------------------
		// Method to create new "PrintSearch" Database

	public static void createDatabase(Connection conn) {

		// check if database exists

		// message to check for tables
		System.out.println("Attempting to create 'PrintSearch' Database...\n");
		System.out.println("Press Enter");
		pressEnter();
		// SQL Code --> must use Try Catch block
		try {
			// statement object
			Statement stmt = conn.createStatement();

			stmt.execute("CREATE DATABASE PrintSearch");

			// print confirmation that the table is dropped
			System.out.println("PrintSearch database created!!!");

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

	// -----------------------------------------------------------------------------------------------------------
	// Method to build our PrintSearch Tables
	public static void buildPrintSearchDatabaseTables(Connection conn,
			ArrayList<AniloxDrawing> aniloxDrawingList) {

		System.out.println(
				"Attemping to build the PrintDrawings table in the PrintSearch Database...");

		System.out.println("Press Enter");

		pressEnter();
		// SQL Code --> must use Try Catch block

		try {

			System.out.println("Attemping to create tables...");
			/* 1. Create the tables */
			// statement object

			Statement stmt = conn.createStatement();
			/* Create AnimalHospital Table */

			stmt.execute("CREATE TABLE PrintDrawings(" + "XLSX VARCHAR," + "XLSM VARCHAR," +
					"PDF VARCHAR," + "DWG VARCHAR," + "SCANNED VARCHAR," + "DRAWING_NAME VARCHAR," +
					"REV VARCHAR," + "DIA_01 VARCHAR," + "DIA_02 VARCHAR," + "FACE_01 VARCHAR," +
					"FACE_02 VARCHAR," + "BEARING_MIN VARCHAR," + "BEARING_MAX VARCHAR," +
					"STEPS VARCHAR," + "OEM VARCHAR," + "TYPE VARCHAR," + "CUSTOMER VARCHAR," +
					"ORIGINAL_CUSTOMER VARCHAR," + "CUSTPN VARCHAR," + "CUSTREV VARCHAR," +
					"NEWBASE VARCHAR," + "DATE VARCHAR," + "SUBCONTRACTOR VARCHAR," +
					"PRODUCTCODE VARCHAR," + "PREVPARTNO VARCHAR," + "DATE_CREATED VARCHAR," +
					"PARTNO VARCHAR" + ");");

			System.out.println("Created all tables successfully!!!");

			/* 2. Add rows to table */

			System.out.println("Attempting to insert values into tables...");
			/* Add rows to "AnimalHospital" table */

			aniloxDrawingList.get(0).getXlsxPath();

			int countA = 0;

			int number = aniloxDrawingList.size();

			for (int i = 0; i < number; i++) {

				StringBuilder sb = new StringBuilder();

				sb.append(
						"INSERT INTO PrintDrawings(XLSX, XLSM, PDF, DWG, SCANNED, DRAWING_NAME, REV, DIA_01, DIA_02, FACE_01, FACE_02," +
								"BEARING_MIN, BEARING_MAX, STEPS, OEM, TYPE, CUSTOMER,ORIGINAL_CUSTOMER, CUSTPN, CUSTREV, NEWBASE, DATE, SUBCONTRACTOR, PRODUCTCODE," +
								"PREVPARTNO, DATE_CREATED, PARTNO)");

				sb.append("VALUES ");
				countA++;

				countA++;
				sb.append("('" + aniloxDrawingList.get(i).getXlsxPath() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getXlsmPath() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getPdfPath() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDmgDrawingPath() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getScannedPath() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDrawingName() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getRevNumber() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDia1() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDia2() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getFace1() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getFace2() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getBearingMin() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getBearingMax() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getSteps() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getOem() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getType() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getCust() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getOriginatingCustomer() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getCustPin() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getCustRev() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getNewBasePrice() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDate() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getSubcontractor() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getProductCode() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getPrevPartNo() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDateCreated() + "', ");

				sb.append("'" + aniloxDrawingList.get(i).getPartNo() + "');");
				stmt.execute(sb.toString());
			}

			System.out.println("PRINTING OUT sb list---->");
			System.out.println("Press Enter");

			pressEnter();

			System.out.println("Values inserted  Succussfully!!!");

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
}
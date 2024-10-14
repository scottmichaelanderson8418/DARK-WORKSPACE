package com.printsearch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreatePrintSearchDatabase {

	// public static Scanner scanner = new Scanner(System.in);

	public static void createPrintDatabase(List<PrintDrawingDto> aniloxDrawingsListDto, List<String> obj) {

		try {

			Connection conn = null;

			System.out.println("aniloxDrawingsListDto.size()= " + aniloxDrawingsListDto.size());

			/* 1. Create connection to database */
			// this will tell us what type of driver we are using
			// Class.forName("com.mysql.cj.jdbc.Driver");
			// creates connection to "" Database

			String url = MySQLDatabaseFinal.DB_ADDRESS;
			String user = MySQLDatabaseFinal.USER_NAME;
			String password = MySQLDatabaseFinal.PASSWORD;

			conn = DriverManager.getConnection(url, user, password);

			System.out.println("Connected to database successfully!!!\n");

			System.out.println("Connected to " + MySQLDatabaseFinal.DB_ADDRESS + " successfully!!!");

			/* 2. Check if the database exists, if so, drop the database */
			boolean databaseExists = databaseExists(conn, MySQLDatabaseFinal.DB_NAME);

			if (!databaseExists) {

				/* 3. Create new database */
				createDatabase(conn);

				conn.close();
			}

			/* 1. Create new connection to database */
			// this will tell us what type of driver we are using
			Class.forName(MySQLDatabaseFinal.JDBC_DRIVER);

			// creates connection to "printDrawings" Database
			Connection connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + MySQLDatabaseFinal.DB_NAME, "root",
					"five2one");
			System.out.println("Connected to database successfully!!!\n");

			System.out.println("Connected to \"jdbc:mysql://localhost:3306/" + MySQLDatabaseFinal.DB_NAME + " successfully!!!");

			System.out.println();

			/* 6. Create table and add data */
			buildPrintDatabaseTables(connn, aniloxDrawingsListDto);

			/* 8. close the connection */

			System.out.println("close the connection...");

			connn.close();

			System.out.println("connection is closed...");
		} catch (SQLException ee) {
			System.out.println("SQL EXCEPTION !!!!!!!!!!!!!!!!!!!!!!!");
			ee.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
			// will show what type of error & the message returned from the
			// error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}

	}

	// end drop table method

	// -----------------------------------------------------------------------------------------------------------
	// Method to Delete the existing database
	public static boolean databaseExists(Connection conn, String databaseName) throws Exception {

		// check if database exists

		// message to check for tables
		System.out.println("\nChecking to see if '" + databaseName + "' Database exist...\n");

		// SQL Code --> must use Try Catch block

		try {
			// statement object
			Statement stmt = conn.createStatement();

			// execute a statement to drop the table

			String sql = "SELECT EXISTS(SELECT schema_name FROM information_schema.schemata WHERE schema_name = ?)";

			PreparedStatement stmt1 = conn.prepareStatement(sql);

			stmt1.setString(1, MySQLDatabaseFinal.DB_NAME);

			ResultSet resultSet = stmt1.executeQuery();

			resultSet.next();

			return resultSet.getBoolean(1);

		} catch (SQLException ee) {
			ee.printStackTrace();

		} catch (Exception e) {
			// will show what type of error & the message returned from the
			// error
			e.printStackTrace();
			System.out.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}

		return false;

	}// end drop table method

	public static void createDatabase(Connection conn) {

		// check if database exists

		// message to check for tables
		System.out.println("Attempting to create '" + MySQLDatabaseFinal.DB_NAME + "' Database...\n");

		// SQL Code --> must use Try Catch block
		try {
			// statement object
			Statement stmt = conn.createStatement();
			String sql = "CREATE DATABASE " + MySQLDatabaseFinal.DB_NAME;
			stmt.execute(sql);

			// print confirmation that the table is dropped
			System.out.println(MySQLDatabaseFinal.DB_NAME + " created!!!");

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
	// Method to build our printsearch Tables
	public static void buildPrintDatabaseTables(Connection conn, List<PrintDrawingDto> printDrawingsListDto) {

		System.out.println("Entering buildPrintDatabaseTables()");

		String noteToConsole = "Attemping to build the " + MySQLDatabaseFinal.DB_TABLE_NAME + " table in the " +
				MySQLDatabaseFinal.DB_NAME + " Database...\n";

		System.out.println(noteToConsole);

		// SQL Code --> must use Try Catch block

		try {

			/* Drop existing tables */

			// Create statement object
			Statement statement = conn.createStatement();

			// Drop table with IF EXISTS clause
			String dropTable = "DROP TABLE IF EXISTS " + MySQLDatabaseFinal.DB_TABLE_NAME;
			statement.execute(dropTable);

			System.out.println("Table " + MySQLDatabaseFinal.DB_TABLE_NAME + " dropped (if it existed).");

			System.out.println("Attemping to create tables...");
			/* 1. Create the tables */
			// statement object

			Statement stmt = conn.createStatement();

			String sql = "USE " + MySQLDatabaseFinal.DB_NAME;

			stmt.execute(sql);

			// /* Create MySQLDatabaseFinal.DB_TABLE_NAME Table */

			String createTableSQL = "CREATE TABLE " + MySQLDatabaseFinal.DB_TABLE_NAME + " (" +
					"id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " + "bearing_max VARCHAR(255), " + "bearing_min VARCHAR(255), " +
					"customer VARCHAR(255), " + "customer_pin VARCHAR(255), " + "customer_revision VARCHAR(255), " +
					"date VARCHAR(255), " + "date_created VARCHAR(255), " + "diameter_low FLOAT NOT NULL, " +
					"diameter_high FLOAT NOT NULL, " + "dmg_drawing_path VARCHAR(255), " + "drawing_name VARCHAR(255), " +
					"face_length_low FLOAT NOT NULL, " + "face_length_high FLOAT NOT NULL, " + "new_base_price VARCHAR(255), " +
					"oem VARCHAR(255), " + "originating_customer VARCHAR(255), " + "part_no VARCHAR(255), " +
					"pdf_path VARCHAR(255), " + "prev_part_no VARCHAR(255), " + "product_code VARCHAR(255), " +
					"rev_number VARCHAR(255), " + "scanned_path VARCHAR(255), " + "steps VARCHAR(255), " +
					"subcontractor VARCHAR(255), " + "type VARCHAR(255), " + "xlsm_path VARCHAR(255), " +
					"xlsx_path VARCHAR(255)" + ")";

			System.out.println(createTableSQL);

			stmt.execute(createTableSQL);

			// System.out.println("Created all tables successfully!!!");

			/* 2. Add rows to table */

			System.out.println("Attempting to insert values into tables...");
			// printDrawingsListDto.get(0).getXlsxPath();

			sql = "USE " + MySQLDatabaseFinal.DB_NAME;

			stmt.execute(sql);

			List<String> objStr = new ArrayList<>();
			int number = printDrawingsListDto.size();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < number; i++) {

				sb = new StringBuilder();

				sb.append("INSERT INTO " + MySQLDatabaseFinal.DB_TABLE_NAME + "(bearing_max , " + "bearing_min , " +
						"customer , " + "customer_pin , " + "customer_revision , " + "date , " + "date_created , " +
						"diameter_low, " + "diameter_high, " + "dmg_drawing_path , " + "drawing_name , " + "face_length_low, " +
						"face_length_high, " + "new_base_price , " + "oem , " + "originating_customer , " + "part_no , " +
						"pdf_path , " + "prev_part_no , " + "product_code , " + "rev_number , " + "scanned_path , " + "steps , " +
						"subcontractor , " + "type , " + "xlsm_path , " + "xlsx_path " + ")");

				sb.append("VALUES(");

				sb.append("'" + printDrawingsListDto.get(i).getBearingMax() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getBearingMin() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getCustomer() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getCustomerPin() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getCustomerRevision() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getDate() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getDateCreated() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getDiameterLow() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getDiameterHigh() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getDmgDrawingPath() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getDrawingName() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getFaceLengthLow() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getFaceLengthHigh() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getNewBasePrice() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getOem() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getOriginatingCustomer() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getPartNo() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getPdfPath() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getPrevPartNo() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getProductCode() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getRevNumber() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getScannedPath() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getSteps() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getSubcontractor() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getType() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getXlsmPath() + "', ");
				sb.append("'" + printDrawingsListDto.get(i).getXlsxPath() + "');");
				System.out.println(sb.toString());

				stmt.execute(sb.toString());

				objStr.add(sb.toString());

			}

			System.out.println(objStr.get(0));

			System.out.println("Values inserted  Succussfully!!!");

		} catch (

		SQLException ee) {
			ee.printStackTrace();
		}

		catch (Exception e) {
			// will show what type of error & the message returned from the
			// error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);

		}

	}

	// Method to build our printsearch Tables
	public static List<String> buildSQLFileList(List<PrintDrawingDto> aniloxDrawingList) {

		List<String> obj = new ArrayList<String>();

		String noteToConsole = "Attemping to build the " + MySQLDatabaseFinal.DB_TABLE_NAME +
				" table in the printsearch Database...\n";

		System.out.println(noteToConsole);

		// SQL Code --> must use Try Catch block

		try {

			System.out.println("Attemping to create tables...");
			/* 1. Create the tables */
			// statement object+

			/* Create "printdrawings" table */
			String createTableSQL = "CREATE TABLE " + MySQLDatabaseFinal.DB_TABLE_NAME + "(" +
					"id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " + "bearing_max VARCHAR(255), " + "bearing_min VARCHAR(255), " +
					"customer VARCHAR(255), " + "customer_pin VARCHAR(255), " + "customer_revision VARCHAR(255), " +
					"date VARCHAR(255), " + "date_created VARCHAR(255), " + "diameter_low FLOAT NOT NULL, " +
					"diameter_high FLOAT NOT NULL, " + "dmg_drawing_path VARCHAR(255), " + "drawing_name VARCHAR(255), " +
					"face_length_low FLOAT NOT NULL, " + "face_length_high FLOAT NOT NULL, " + "new_base_price VARCHAR(255), " +
					"oem VARCHAR(255), " + "originating_customer VARCHAR(255), " + "part_no VARCHAR(255), " +
					"pdf_path VARCHAR(255), " + "prev_part_no VARCHAR(255), " + "product_code VARCHAR(255), " +
					"rev_number VARCHAR(255), " + "scanned_path VARCHAR(255), " + "steps VARCHAR(255), " +
					"subcontractor VARCHAR(255), " + "type VARCHAR(255), " + "xlsm_path VARCHAR(255), " +
					"xlsx_path VARCHAR(255)" + ")";

			System.out.println("Created all tables successfully!!!");

			/* 2. Add rows to table */

			System.out.println("Attempting to insert values into tables...");

			aniloxDrawingList.get(0).getXlsxPath();

			int number = aniloxDrawingList.size();

			for (int i = 0; i < number; i++) {

				StringBuilder sb = new StringBuilder();

				sb.append("INSERT INTO " + MySQLDatabaseFinal.DB_TABLE_NAME +
						"(bearing_max , bearing_min , customer , customer_pin , customer_revision , date , date_created ,diameterLow, diameterHigh, dmg_drawing_path , drawing_name , faceLengthLow , faceLengthHigh, new_base_price , oem ,originating_customer , part_no , pdf_path , prev_part_no , product_code , rev_number , scanned_path ,steps , subcontractor , type , xlsm_path , xlsx_path )");

				sb.append("VALUES ");

				sb.append("('" + aniloxDrawingList.get(i).getBearingMax() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getBearingMin() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getCustomer() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getCustomerPin() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getCustomerRevision() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDate() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDateCreated() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDiameterLow() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDiameterHigh() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDmgDrawingPath() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getDrawingName() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getFaceLengthLow() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getFaceLengthHigh() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getNewBasePrice() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getOem() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getOriginatingCustomer() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getPartNo() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getPdfPath() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getPrevPartNo() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getProductCode() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getRevNumber() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getScannedPath() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getSteps() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getSubcontractor() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getType() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getXlsmPath() + "', ");
				sb.append("'" + aniloxDrawingList.get(i).getXlsxPath() + "');");

				obj.add(sb.toString());

			}

			System.out.println(obj.get(0));

			// System.out.println("PRINTING OUT sb list---->");
			// System.out.println("Press Enter");

			// pressEnter();

			System.out.println("Values inserted  Succussfully!!!");
			return obj;

		}

		catch (Exception e) {
			// will show what type of error & the message returned from the
			// error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;

	}

}
package com.printsearch;

import java.util.LinkedList;
import java.util.List;

/**
 * The CreateSQLFile class provides methods to generate SQL statements for
 * creating and populating the printdrawings table in the printsearch database.
 */
public class CreateSQLFile {

	/**
	 * Generates SQL statements to create the printdrawings table and insert rows
	 * based on the provided list of PrintDrawingDto objects.
	 *
	 * @param aniloxDrawingList a list of PrintDrawingDto objects containing data
	 *                          for each row to be inserted
	 * @return a list of SQL statements as strings
	 */
	public static List<String> createSQLFileForPrintDrawings(List<PrintDrawingDto> aniloxDrawingList) {

		List<String> obj = new LinkedList<String>();

		String noteToConsole = "Attempting to build the PrintDrawing table in the printsearch Database...\n";
		System.out.println(noteToConsole);
		System.out.println("Press Enter");

		// SQL Code --> must use Try Catch block
		try {
			System.out.println("Attempting to create tables...");
			/* 1. Create the tables */
			// statement object+

			/* Create Table */
			String createTableSQL = "CREATE TABLE printdrawings (" + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
					"bearing_max VARCHAR(255), " + "bearing_min VARCHAR(255), " + "customer VARCHAR(255), " +
					"customer_pin VARCHAR(255), " + "customer_revision VARCHAR(255), " + "date VARCHAR(255), " +
					"date_created VARCHAR(255), " + "diameter_low FLOAT NOT NULL, " + "diameter_high FLOAT NOT NULL, " +
					"dmg_drawing_path VARCHAR(255), " + "drawing_name VARCHAR(255), " + "face_length_low FLOAT NOT NULL, " +
					"face_length_high FLOAT NOT NULL, " + "new_base_price VARCHAR(255), " + "oem VARCHAR(255), " +
					"originating_customer VARCHAR(255), " + "part_no VARCHAR(255), " + "pdf_path VARCHAR(255), " +
					"prev_part_no VARCHAR(255), " + "product_code VARCHAR(255), " + "rev_number VARCHAR(255), " +
					"scanned_path VARCHAR(255), " + "steps VARCHAR(255), " + "subcontractor VARCHAR(255), " +
					"type VARCHAR(255), " + "xlsm_path VARCHAR(255), " + "xlsx_path VARCHAR(255)" + ")";
			System.out.println(createTableSQL);

			System.out.println("Created all tables successfully!!!");

			/* 2. Add rows to table */
			System.out.println("Attempting to insert values into tables...");

			int number = aniloxDrawingList.size();

			for (int i = 0; i < number; i++) {

				StringBuilder sb = new StringBuilder();

				sb.append("INSERT INTO " + MySQLDatabaseFinal.DB_TABLE_NAME +
						"(bearing_max, bearing_min, customer, customer_pin, customer_revision, date, date_created, diameter_low, diameter_high, dmg_drawing_path, drawing_name, face_length_low, face_length_high, new_base_price, oem, originating_customer, part_no, pdf_path, prev_part_no, product_code, rev_number, scanned_path, steps, subcontractor, type, xlsm_path, xlsx_path) ");

				sb.append("VALUES(");
				sb.append("'" + aniloxDrawingList.get(i).getBearingMax() + "', ");
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

			obj.add(0, "use printdrawingsdatabase;");

			System.out.println(obj.get(0));

			System.out.println("Values inserted Successfully!!!");
			return obj;

		} catch (Exception e) {
			// will show what type of error & the message returned from the error
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;
	}
}

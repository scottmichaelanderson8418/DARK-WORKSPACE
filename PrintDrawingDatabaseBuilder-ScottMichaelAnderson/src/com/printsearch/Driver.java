package com.printsearch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The `Driver` class is the main class of the PrintSearch application. It reads
 * data from a CSV file, processes it, and writes the processed data to a text
 * file and a database.
 *
 * @author Your Name (replace with your name)
 * @since [date] (replace with the date you created the class)
 */
public class Driver {

	// Scanner object for user input
	public static Scanner scanner = new Scanner(System.in);

	/**
	 * The main method of the program.
	 *
	 * @param args command line arguments (unused)
	 * @throws FileNotFoundException if the input file is not found
	 * @throws NumberFormatException if there is a parsing error with numeric data
	 * @throws IOException           if there is an error reading or writing files
	 */
	public static void main(String[] args)
			throws FileNotFoundException, NumberFormatException, IOException {
		//
		// Lists to store data
		List<PrintDrawing> printDrawingsList = new ArrayList<>();
		List<PrintDrawingDto> printDrawingsListDto = new ArrayList<>();
		List<String> strList = new ArrayList<>();
		List<String[]> strListB = new ArrayList<>();

		// Process data using DataTools methods
		strList = DataTools.createStrList(strList);
		strListB = DataTools.splitStringList(strList, strListB);
		printDrawingsList = DrawingManager.add(strListB);

		// Print and clean data
		// DataTools.printAll(printDrawingsList);

		printDrawingsList = DataTools.cleanUpAll(printDrawingsList);
		printDrawingsList = DataTools.cleanUpAllNumberCol(printDrawingsList);
		printDrawingsList = DataTools.cleanUpCustomerColumn(printDrawingsList);

		// DataTools.printAll(printDrawingsList);

		// Write cleaned data to text file
		DataTools.writeStrListToFileFinal01(printDrawingsList);
		System.out.println("Output aniloxRollList to text File Succussfully.....");

		// Convert PrintDrawing to PrintDrawingDto objects
		printDrawingsListDto = DataTools.convertObj(printDrawingsList);

		printDrawingsListDto = DataTools.convertObjNone(printDrawingsListDto);

		// Generate SQL statements
		List<String> masterSQLScript = new ArrayList<>();
		List<String> obj = CreateSQLFile.createSQLFileForPrintDrawings(printDrawingsListDto);
		CreatePrintSearchDatabase.createPrintDatabase(printDrawingsListDto, obj);

		// Add generated SQL statements to master list
		for (String sqlStatement : obj) {
			masterSQLScript.add(sqlStatement);
		}

		// Print sample SQL statements
		for (int k = 0; k < 11; k++) {
			System.out.println(obj.get(k));
		}

		// Write SQL statements to a file
		DataTools.writeSQLScript(masterSQLScript);

		scanner.close();
	}

	/**
	 * Prints a formatted table of data from a list of String arrays.
	 *
	 * @param strListB the list of String arrays to print
	 */
	public static void printList(List<String[]> strListB) {

		// Define the column numbers to print
		int[] columnNumber = { 7, 8, 9, 10 };

		// Print table header
		System.out.println("ID\t\tDIA01\t\tDIA_02\t\tFACE_01\t\tFACE_02");

		// Loop through the list and print each row with formatted data
		for (int i = 0; i < 100; i++) {
			System.out.print(i + "\t\t" + strListB.get(i)[columnNumber[0]] + "\t\t" +
					strListB.get(i)[columnNumber[1]] + "\t\t" + strListB.get(i)[columnNumber[2]] +
					"\t\t" + strListB.get(i)[columnNumber[3]] + "   ");
		}
		System.out.println(); // Print a newline after the loop
	}

}

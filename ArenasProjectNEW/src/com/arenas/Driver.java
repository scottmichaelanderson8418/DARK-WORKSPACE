package com.arenas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * The driver will instantiate the arenaObjList & strList ArrayList
 * 
 */
public class Driver {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
			throws FileNotFoundException, NumberFormatException, IOException, SQLException {

		Scanner scanner = new Scanner(System.in);
		// Create list to store the "Arena Class" Objects
		ArrayList<Arena> arenaObjList = new ArrayList<Arena>();

		// Create a list of Strings to process the text in the IndoorArena.txt file
		ArrayList<String> strList = new ArrayList<String>();

		// Read "indoorArena.txt" and fill up an ArrayList with Strings
		strList = createStrList(strList);

		// System.out.println("Press Enter");
		// // DataTools.pressEnter();

		// Create database connection A
		// Connection connA = ArenasDBTools.createDatabaseConnectionA(arenaObjList);

		// /* Delete Database if it exists */
		// ArenasDBTools.deleteDatabase(connA);
		//
		// /* Create Database */
		// ArenasDBTools.createDatabase(connA);

		// /* Close the connection A */
		// connA.close();

		Connection connB = null;
		/* Create database connection B */
		connB = ArenasDBTools.createDatabaseConnectionB(arenaObjList);

		/* Check if the table exist, if so, drop the table */
		System.out.println("Checking for existing tables.");
		ArenasDBTools.dropTable(connB);

		/* Create list of objects */
		arenaObjList = DataTools.createArenaObjList(strList, arenaObjList);

		/* Build Database Tables */

		ArenasDBTools.buildDatabaseTables(connB, arenaObjList);

		/* Display All Tables */

		printObjList(arenaObjList);

		// From here we need to unwrap the arenaList and create a database
		scanner.close();

	}

	// Method prints the ArenaList
	public static void printObjList(ArrayList<Arena> arenaObjList) {
		System.out.print("\n\n");

		String[] titleBar = { "Venue", "City", "State", "MaxCapacity", "YearOpened", "TeamName",
				"Sport", "League" };
		int k = 0;

		while (k < titleBar.length) {
			System.out.printf("%-60s \t", titleBar[k].toUpperCase());
			k++;
		}
		System.out.println();

		for (int i = 0; i < arenaObjList.size(); i++) {

			System.out.printf("%-60s \t", arenaObjList.get(i).getVenueName());

			System.out.printf("%-60s \t", arenaObjList.get(i).getCity());

			System.out.printf("%-60s \t", arenaObjList.get(i).getState());

			System.out.printf("%-60s \t", arenaObjList.get(i).getMaxCapacity());

			System.out.printf("%-60d \t", arenaObjList.get(i).getYearOpened());

			System.out.printf("%-60d \t", arenaObjList.get(i).getMaxCapacity());

			System.out.printf("%-60s \t", arenaObjList.get(i).getTeam().getTeamName());

			System.out.printf("%-60s \t", arenaObjList.get(i).getMaxCapacity());

			System.out.printf("%-60s \t", arenaObjList.get(i).getTeam().getSport());

			System.out.printf("%-60s \t", arenaObjList.get(i).getTeam().getLeague());

			System.out.println();

		}
	}

	// Method Creates an ArrayList of Strings using the lines of text in the "Indoor
	// Arena.txt"
	public static ArrayList<String> createStrList(ArrayList<String> strList) {

		// Streams allow us to process data in a clear and concise way
		FileReader fileReader = null;
		String line = "";
		try {

			fileReader = new FileReader("IndoorArenas.txt");

			// BufferedReader Class uses the FileReader Object and reads the file line by
			// line
			BufferedReader reader = new BufferedReader(fileReader);

			// readLine() --> reads each line of text and terminates when it reaches the
			// of the line
			while ((line = reader.readLine()) != null) {

				strList.add(line);

			}

			fileReader.close();
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (NumberFormatException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return strList;

	}

}

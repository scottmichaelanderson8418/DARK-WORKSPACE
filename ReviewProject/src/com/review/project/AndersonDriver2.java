package com.review.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AndersonDriver2 {

	public static void main(String[] args)
			throws FileNotFoundException, NumberFormatException, IOException {

		Scanner scanner = new Scanner(System.in);

		ArrayList<AniloxRoll> arenaList = new ArrayList<AniloxRoll>();

		ArrayList<String> strList = new ArrayList<String>();

		// Read "indoorArenas.txt" and fill up an ArrayList with Strings
		strList = createStrList(strList);

		int countA = 0;

		// LOOP through the ArrayList<String> and fill up the ArrayList<Arena> list with
		// Arena Objects
		// we subtract "strList.size()" -1 because there are two blank lines at the end
		// of the document
		for (int i = 0; i < strList.size() - 1; i++) {

			AniloxRoll arenaObj = createArenaObject();

			Tenant tenantObj = createTenantObject();
			countA = 0;

			// Loop through the lines for each new instance of the Arena Class and Tenant
			// Class
			for (int k = 0; k < 8; k++) {

				// switch function to assign the "arenaObj" fields with values from the
				// "IndoorArena.txt" file
				switch (countA) {

				case 0:

					arenaObj.setVenueName(strList.get(i));
					break;
				case 1:

					arenaObj.setCity(strList.get(i));
					break;
				case 2:

					arenaObj.setState(strList.get(i));
					break;
				case 3:

					int number = (Integer.parseInt(strList.get(i)));
					arenaObj.setMaxCapacity(number);
					break;
				case 4:

					arenaObj.setYearOpened(Integer.parseInt(strList.get(i)));

				case 5:

					tenantObj.setTeamName(strList.get(i));
					break;
				case 6:

					tenantObj.setSport(strList.get(i));
					break;
				case 7:

					tenantObj.setLeague(strList.get(i));
					break;
				}

				// When the arenaObj is completely instantiated then we can add it to the
				// arenaList
				if (countA == 7) {

					// Now that the tenantObj is instantiated
					arenaObj.setTeam(tenantObj);

					// Add the arenaObj to the arenaList
					arenaList.add(arenaObj);

				}

				i++;

				countA++;

			}

		}

		pressEnter(scanner);

		printArenaList(arenaList);

		scanner.close();
	}

	public static AniloxRoll createArenaObject() {

		return new AniloxRoll();

	}

	public static Tenant createTenantObject() {

		return new Tenant();

	}

	public static void printArenaList(ArrayList<AniloxRoll> arenaList) {

		for (int i = 0; i < arenaList.size(); i++) {

			System.out.println(arenaList.get(i).toString());

			System.out.println();

		}
	}

	public static void pressEnter(final Scanner scanner) {

		scanner.nextLine();

	}

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

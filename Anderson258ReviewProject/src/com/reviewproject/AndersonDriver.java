
package com.reviewproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AndersonDriver {

	public static void main(String[] args)
			throws FileNotFoundException, NumberFormatException, IOException {
		// Create list to store the "Arena Class" Objects
		ArrayList<Arena> arenaList = new ArrayList<Arena>();

		// Create a list of Strings to process the text in the IndoorArenas.txt file
		ArrayList<String> strList = new ArrayList<String>();

		// Read "indoorArenas.txt" and fill up an ArrayList with Strings
		strList = createStrList(strList);

		// counter to keep track of the location of Strings and Arena setter methods in
		// the switch function
		int countA = 0;

		// LOOP through the ArrayList<String> and fill up the ArrayList<Arena> list with
		// Arena Objects
		// we subtract "strList.size()" -1 because there are two blank lines at the end
		// of the document
		for (int i = 0; i < strList.size() - 1; i++) {

			Arena arenaObj = createArenaObject();

			Tenant tenantObj = createTenantObject();
			countA = 0;

			// Loop through the lines for each new instance of the Arena Class and Tenant
			// Class
			for (int k = 0; k < 8; k++) {

				// switch function to assign the "arenaObj" fields with values from the
				// "IndoorArena.txt" file
				switch (countA) {

				case 0:
					// Set VenueName
					arenaObj.setVenueName(strList.get(i));
					break;
				case 1:
					// Set City
					arenaObj.setCity(strList.get(i));
					break;
				case 2:
					// SetState
					arenaObj.setState(strList.get(i));
					break;
				case 3:
					// Set Max Capacity
					int number = (Integer.parseInt(strList.get(i)));
					arenaObj.setMaxCapacity(number);
					break;
				case 4:
					// Set Year Opened
					arenaObj.setYearOpened(Integer.parseInt(strList.get(i)));
					break;
				case 5:
					// Set Team Name
					tenantObj.setTeamName(strList.get(i));
					break;
				case 6:
					// Set Sport name
					tenantObj.setSport(strList.get(i));
					break;
				case 7:
					// set league name
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

		printArenaList(arenaList);

	}

	// Method to create Arena Class Object
	public static Arena createArenaObject() {

		return new Arena();

	}

	// Method creates a Tenant Class Object
	public static Tenant createTenantObject() {

		return new Tenant();

	}

	// Method prints the ArenaList
	public static void printArenaList(ArrayList<Arena> arenaList) {

		for (int i = 0; i < arenaList.size(); i++) {

			System.out.println(arenaList.get(i).toString());

			System.out.println();

		}
	}

	// Method Creates an ArrayList of Strings using the lines of text in the "Indoor
	// Arenas.txt"
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

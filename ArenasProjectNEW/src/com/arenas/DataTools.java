package com.arenas;

import java.util.ArrayList;
import java.util.Scanner;

public class DataTools {
	public static final Scanner scanner = new Scanner(System.in);

	public static ArrayList<Arena> createArenaObjList(ArrayList<String> strList,
			ArrayList<Arena> arenaObjList) {
		// counter to keep track of the location of Strings and Arena setter methods in
		// the switch function
		int countA = 0;

		// LOOP through the ArrayList<String> and fill up the ArrayList<Arena> list with
		// Arena Objects
		// we subtract "strList.size()" -1 because there are two blank lines at the end
		// of the document
		for (int i = 0; i < strList.size() - 1; i++) {

			Arena arenaObj = Arena.createArenaObject();

			Tenant tenantObj = Tenant.createTenantObject();
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

					// instantiating an instance of the Tenant Class initialized with the team
					// object
					// The instance of the Tenant Class is associated with the current Arena Object
					arenaObj.setTeam(tenantObj);

					// Add the object to the list
					arenaObjList.add(arenaObj);

				}

				i++;

				countA++;

			}

		}
		return arenaObjList;
	}

	// press enter to pause the code
	public static void pressEnter() {

		scanner.nextLine();

	}
}

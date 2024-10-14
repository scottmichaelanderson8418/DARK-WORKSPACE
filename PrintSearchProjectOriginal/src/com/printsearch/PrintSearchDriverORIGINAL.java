package com.printsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * The PrintSearchDriver will read the source file : "HARPER_ACCESS_1.csv" and
 * output the data into a file named "HARPER_ACCESS_1.txt"
 * 
 */
public class PrintSearchDriverORIGINAL {

	public static void main(String[] args)
			throws FileNotFoundException, NumberFormatException, IOException {

		Scanner scanner = new Scanner(System.in);

		ArrayList<AniloxRoll> aniloxRollList = new ArrayList<AniloxRoll>();

		ArrayList<String> strList = new ArrayList<String>();
		ArrayList<String[]> strListB = new ArrayList<String[]>();

		// Read "indoorArenas.txt" and fill up an ArrayList with Strings
		strList = createStrList(strList);

		for (String x : strList) {

			String[] arrOfStr = x.split(",", -2);

			strListB.add(arrOfStr);
		}

		for (int i = 0; i < strListB.size() - 1; i++) {

			for (int j = 0; j < strListB.get(0).length; j++) {
				if (strListB.get(i)[j].equals("")) {
					strListB.get(i)[j] = "NONE";
				}
				// System.out.println("Element = " + j + " = " + strListB.get(i)[j]);

			}
			// System.out.println();

		}

		int countA = 0;

		// LOOP through the ArrayList<String> and fill up the ArrayList<Arena> list with
		// Arena Objects
		// we subtract "strList.size()" -1 because there are two blank lines at the end
		// of the document
		for (int i = 0; i < strList.size() - 1; i++) {

			AniloxRoll aniloxRollObj = createAniloxRollObject();

			// Loop through the lines for each new instance of the Arena Class and Tenant
			// Class
			for (int k = 0; k < 27; k++) {

				// switch function to assign the "arenaObj" fields with values from the
				// "IndoorArena.txt" file
				switch (k) {

				case 0:
					// trackVariableValues(strList, strListB, k, i);

					aniloxRollObj.setXlsxPath(strListB.get(i)[k]);
					break;
				case 1:

					// trackVariableValues(strList, strListB, k, i);
					break;
				case 2:

					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setPdfPath(strListB.get(i)[k]);
					break;

				case 3:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setDmgDrawingPath(strListB.get(i)[k]);
					break;

				case 4:

					// trackVariableValues(strList, strListB, k, i);

					aniloxRollObj.setScannedPath(strListB.get(i)[k]);
					break;

				case 5:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setDrawingName(strListB.get(i)[k]);
					break;

				case 6:

					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setRevNumber(strListB.get(i)[k]);
					break;
				case 7:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setDia1(strListB.get(i)[k]);
					break;
				case 8:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setDia2(strListB.get(i)[k]);
					break;
				case 9:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setFace1(strListB.get(i)[k]);
					break;
				case 10:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setFace2(strListB.get(i)[k]);
					break;
				case 11:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setBearingMax(strListB.get(i)[k]);
					break;
				case 12:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setBearingMin(strListB.get(i)[k]);
					break;
				case 13:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setSteps(strListB.get(i)[k]);
					break;

				case 14:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setOem(strListB.get(i)[k]);
					break;

				case 15:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setType(strListB.get(i)[k]);
					break;
				case 16:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setCust(strListB.get(i)[k]);
					break;
				case 17:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setOriginatingCustomer(strListB.get(i)[k]);
					break;
				case 18:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setCustPin(strListB.get(i)[k]);
					break;
				case 19:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setCustRev(strListB.get(i)[k]);
					break;
				case 20:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setNewBasePrice(strListB.get(i)[k]);
					break;

				case 21:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setDate(strListB.get(i)[k]);
					break;

				case 22:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setSubcontractor(strListB.get(i)[k]);
					break;

				case 23:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setProductCode(strListB.get(i)[k]);
					break;

				case 24:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setPrevPartNo(strListB.get(i)[k]);
					break;

				case 25:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setDateCreated(strListB.get(i)[k]);
					break;

				case 26:
					// trackVariableValues(strList, strListB, k, i);
					aniloxRollObj.setPartNo(strListB.get(i)[k]);

					break;

				}

				// When the arenaObj is completely instantiated then we can add it to the
				// arenaList
				if (k == 26) {

					aniloxRollList.add(aniloxRollObj);

				}

			}

		}

		System.out.println("PRESS ENTER");
		pressEnter(scanner);

		// print list to console
		// printList(aniloxRollList);

		writeStrList(aniloxRollList);

		System.out.println("Output aniloxRollList to text File.....");

		scanner.close();
	}

	public static void trackVariableValues(ArrayList<String> strList, ArrayList<String[]> strListB,
			int k, int i) {
		System.out.println("k = " + k);
		System.out.println("strList.get(" + i + ")= " + strList.get(i));
		System.out.println("strListB.get(" + i + ")[" + k + "] = " + strListB.get(i)[k]);
		System.out.println();

	}

	public static AniloxRoll createAniloxRollObject() {

		return new AniloxRoll();

	}

	public static void printList(ArrayList<AniloxRoll> aniloxRollList) {

		for (int i = 0; i < aniloxRollList.size(); i++) {

			aniloxRollList.get(i).print();

			System.out.println();

		}
	}

	public static void pressEnter(final Scanner scanner) {

		scanner.nextLine();

	}

	public static void writeStrList(ArrayList<AniloxRoll> aniloxRollList) {
		FileWriter fw = null;

		String line = "";
		// Create New File Method

		createNewFile();
		int i = 0;
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter("HARPER_ACCESS_1.txt"));

			while (i < aniloxRollList.size()) {

				writer.write(aniloxRollList.get(i).toString());
				writer.newLine();

				i++;
			}

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void createNewFile() {
		try {
			File myObj = new File("HARPER_ACCESS_1.txt");

			if (myObj.createNewFile()) {
				System.out.println("File successfully created :)");
			} else {
				System.out.println("File already Exists)");
			}

		} catch (IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}

	public static ArrayList<String> createStrList(ArrayList<String> strList) {

		// Streams allow us to process data in a clear and concise way
		FileReader fd = null;
		String line = "";

		try {

			fd = new FileReader("HARPER_ACCESS_1.csv");

			BufferedReader reader = new BufferedReader(fd);

			// readLine() --> reads each line of text and terminates when it reaches the
			// of the line
			while ((line = reader.readLine()) != null) {

				strList.add(line);

			}

			// close instance of FileReader
			fd.close();

			// close instance of BufferedReader
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

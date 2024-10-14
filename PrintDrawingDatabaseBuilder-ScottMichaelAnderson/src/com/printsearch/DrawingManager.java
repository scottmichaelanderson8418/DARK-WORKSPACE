package com.printsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrawingManager {

	public static Scanner scanner = new Scanner(System.in);
	// What should I do to make DrawingManager accept any list? 2nd Approach

	private static List<PrintDrawing> drawingsList = new ArrayList<PrintDrawing>();

	public static String temp1 = "";

	// Add Method
	public static List<PrintDrawing> add(List<String[]> strListB) {

		for (int i = 0; i < strListB.size(); i++) {

			PrintDrawing aniloxRollObj = createAniloxRollObject();

			for (int k = 0; k < 28; k++) {

				switch (k) {

				case 0:

					aniloxRollObj.setXlsxPath(strListB.get(i)[k]);
					break;
				case 1:

					aniloxRollObj.setXlsmPath(strListB.get(i)[k]);
					break;
				case 2:

					aniloxRollObj.setPdfPath(strListB.get(i)[k]);
					break;

				case 3:

					aniloxRollObj.setDmgDrawingPath(strListB.get(i)[k]);
					break;

				case 4:

					aniloxRollObj.setScannedPath(strListB.get(i)[k]);
					break;

				case 5:

					aniloxRollObj.setDrawingName(strListB.get(i)[k]);
					break;

				case 6:

					aniloxRollObj.setRevNumber(strListB.get(i)[k]);
					break;
				case 7:

					aniloxRollObj.setDiameterLow(strListB.get(i)[k]);

					break;
				case 8:

					aniloxRollObj.setDiameterHigh(strListB.get(i)[k]);

					break;
				case 9:
					aniloxRollObj.setFaceLengthLow(strListB.get(i)[k]);
					break;
				case 10:
					aniloxRollObj.setFaceLengthHigh(strListB.get(i)[k]);
					break;
				case 11:
					System.out.println("i = " + i);
					System.out.println("strListB.get(i)[k]) = " + strListB.get(i)[k]);
					aniloxRollObj.setBearingMax(strListB.get(i)[k]);
					break;
				case 12:

					aniloxRollObj.setBearingMin(strListB.get(i)[k]);
					break;
				case 13:

					aniloxRollObj.setSteps(strListB.get(i)[k]);
					break;

				case 14:

					aniloxRollObj.setOem(strListB.get(i)[k]);
					break;

				case 15:

					aniloxRollObj.setType(strListB.get(i)[k]);
					break;
				case 16:

					aniloxRollObj.setCustomer(strListB.get(i)[k]);
					break;
				case 17:

					aniloxRollObj.setOriginatingCustomer(strListB.get(i)[k]);
					break;
				case 18:

					aniloxRollObj.setCustomer(strListB.get(i)[k]);
					break;
				case 19:

					aniloxRollObj.setCustomer(strListB.get(i)[k]);
					break;
				case 20:

					aniloxRollObj.setNewBasePrice(strListB.get(i)[k]);
					break;

				case 21:

					aniloxRollObj.setDate(strListB.get(i)[k]);
					break;

				case 22:

					aniloxRollObj.setSubcontractor(strListB.get(i)[k]);

					break;

				case 23:

					aniloxRollObj.setProductCode(strListB.get(i)[k]);
					break;

				case 24:

					aniloxRollObj.setPrevPartNo(strListB.get(i)[k]);
					break;

				case 25:

					aniloxRollObj.setDateCreated(strListB.get(i)[k]);
					break;

				case 26:

					aniloxRollObj.setPartNo(strListB.get(i)[k]);

					break;

				}

				// When the aniloxRollObj is completely instantiated then we can add it to the
				// aniloxRollList
				if (k == 26) {

					drawingsList.add(aniloxRollObj);
				}
			}
		}

		return drawingsList;

	}

	// Clean up the bearingMin and bearingMax fields
	public static String cleanBearingValue(String bearingValue) {

		int countInteger = 0;
		String tempInt = "";

		String[] bearingAry = bearingValue.split(" ");

		for (int i = 0; i < bearingAry.length; i++) {

			if (matchString(bearingAry[i])) {

			} else {
				tempInt = bearingAry[i];
				countInteger++;
			}

		}

		if (countInteger > 0) {
			return tempInt;
		} else {
			return bearingValue;
		}

	}

	// Clean up the digits field
	public static String cleanDigits(String number) {
		String temp1 = "";
		number = number + "00000";
		if (number.length() < 1) {
			number = number + "0000";
		}

		temp1 = number;
		if (temp1.length() > 4) {
			String temp2 = temp1.substring(0, 4);
			return temp2;
		}

		return temp1;

	}

	// Ensure that the String value contains only digits
	public static boolean containsOnlyDigits(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;

	}

	// create anilox roll object
	public static PrintDrawing createAniloxRollObject() {

		return new PrintDrawing();

	}

	// // get method to return the ArrayList of drawings
	// public static List<PrintDrawingsDto> getDrawings() {
	// return drawingsList;
	// }

	// find integers and return boolean value
	public static boolean matchIntegers(String value) {

		boolean matchFound1 = false;

		Pattern pattern1 = Pattern.compile("[0-9]+|.", Pattern.CASE_INSENSITIVE);

		Matcher matcher1 = pattern1.matcher(value);

		matchFound1 = matcher1.find();

		return matchFound1;

	}

	// determine if String value contains a String and then return boolean
	public static boolean matchString(String value) {

		boolean matchFound1 = false;

		Pattern pattern1 = Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE);

		Matcher matcher1 = pattern1.matcher(value);

		matchFound1 = matcher1.find();

		return matchFound1;

	}

	// Setting method for ArrayList<AniloxDrawing> drawings
	public static void setDrawings(LinkedList<PrintDrawing> drawings) {
		DrawingManager.drawingsList = drawings;
	}

	LinkedList<String[]> strListB = new LinkedList<String[]>();

	public List<String[]> getStrListB() {
		return strListB;
	}

	// if (matchFound1) {
	// temp = bearingValue.substring(0, 5);
	// return temp;
	// }
	// return bearingValue;
	//
	// }

	// setStrListB Method
	public void setStrListB(LinkedList<String[]> strListB) {
		this.strListB = strListB;
	}

}

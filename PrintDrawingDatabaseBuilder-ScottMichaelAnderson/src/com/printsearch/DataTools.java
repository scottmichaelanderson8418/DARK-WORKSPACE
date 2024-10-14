package com.printsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class providing various data cleaning and conversion tools.
 */
public class DataTools {

	/** Scanner object for input operations. */
	public static Scanner Scanner = new Scanner(System.in);

	/**
	 * Cleans up decimal columns by removing all alphabetic characters from the
	 * input string.
	 *
	 * @param obj the input string to be cleaned
	 * @return the cleaned string with alphabetic characters removed
	 */
	public static String cleanUpDecimalColumns(String obj) {
		obj = obj.replaceAll("[a-zA-Z]", "");
		return obj;
	}

	/**
	 * Removes null or blank values from specified columns in a list of string
	 * arrays. The specified columns are replaced with an empty string if a match is
	 * found.
	 *
	 * @param strListB the list of string arrays to be processed
	 * @return a new list of string arrays with the cleaned data
	 */
	public static List<String[]> removeNull(List<String[]> strListB) {
		Pattern pattern = Pattern.compile("[a-zA-Z]", Pattern.CASE_INSENSITIVE);
		List<String[]> newList = new ArrayList<>();
		int[] columnNumber = { 7, 8, 11, 12 };

		for (int i = 0; i < strListB.size(); i++) {
			newList.add(new String[strListB.get(i).length]);
		}

		for (int i = 0; i < strListB.size(); i++) {
			for (int k : columnNumber) {
				newList.get(i)[k] = strListB.get(i)[k];
			}
		}

		for (int i = 0; i < strListB.size(); i++) {
			for (int k : columnNumber) {
				Matcher matcher = pattern.matcher(strListB.get(i)[k]);
				if (matcher.find()) {
					strListB.get(i)[k] = "";
					newList.get(i)[k] = strListB.get(i)[k];
				}
			}
		}

		return newList;
	}

	public static List<PrintDrawing> cleanUpCustomerColumn(List<PrintDrawing> obj) {

		for (int i = 1; i < obj.size(); i++) {

			PrintDrawing drawing = obj.get(i);

			drawing.setXlsmPath(drawing.getXlsmPath());
			drawing.setXlsxPath(drawing.getXlsxPath());
			drawing.setPdfPath(drawing.getPdfPath());
			drawing.setScannedPath(drawing.getScannedPath());
			drawing.setDmgDrawingPath(drawing.getDmgDrawingPath());
			drawing.setDrawingName(drawing.getDrawingName());

			drawing.setDiameterLow(cleanUpQuotes(drawing.getDiameterLow()));
			drawing.setDiameterHigh(cleanUpQuotes(drawing.getDiameterHigh()));
			drawing.setFaceLengthLow(cleanUpQuotes(drawing.getFaceLengthLow()));
			drawing.setFaceLengthHigh(cleanUpQuotes(drawing.getFaceLengthHigh()));

			if (drawing.getCustomer().equals("NONE") || drawing.getCustomer().length() < 5) {
				drawing.setCustomer(drawing.getOem());
			} else {

				drawing.setCustomer(drawing.getCustomer());
			}

			drawing.setOem(drawing.getOem());
			drawing.setBearingMin(drawing.getBearingMin());
			drawing.setBearingMax(drawing.getBearingMax());
			drawing.setCustomerPin(drawing.getCustomerPin());
			drawing.setCustomerRevision(drawing.getCustomerRevision());
			drawing.setDate(drawing.getDate());
			drawing.setDateCreated(drawing.getDateCreated());
			drawing.setNewBasePrice(drawing.getNewBasePrice());
			drawing.setOriginatingCustomer(drawing.getOriginatingCustomer());
			drawing.setPartNo(drawing.getPartNo());
			drawing.setPrevPartNo(drawing.getPrevPartNo());
			drawing.setProductCode(drawing.getProductCode());
			drawing.setRevNumber(drawing.getRevNumber());
			drawing.setSteps(drawing.getSteps());
			drawing.setSubcontractor(drawing.getSubcontractor());
			drawing.setType(drawing.getType());
		}
		return obj;
	}

	/**
	 * Cleans up all number columns in a list of PrintDrawing objects.
	 *
	 * @param obj the list of PrintDrawing objects to be cleaned
	 * @return the cleaned list of PrintDrawing objects
	 */
	public static List<PrintDrawing> cleanUpAllNumberCol(List<PrintDrawing> obj) {
		for (int i = 1; i < obj.size(); i++) {

			PrintDrawing drawing = obj.get(i);

			drawing.setXlsmPath(drawing.getXlsmPath());
			drawing.setXlsxPath(drawing.getXlsxPath());
			drawing.setPdfPath(drawing.getPdfPath());
			drawing.setScannedPath(drawing.getScannedPath());
			drawing.setDmgDrawingPath(drawing.getDmgDrawingPath());
			drawing.setDrawingName(drawing.getDrawingName());

			drawing.setDiameterLow(cleanUpQuotes(drawing.getDiameterLow()));
			drawing.setDiameterHigh(cleanUpQuotes(drawing.getDiameterHigh()));
			drawing.setFaceLengthLow(cleanUpQuotes(drawing.getFaceLengthLow()));
			drawing.setFaceLengthHigh(cleanUpQuotes(drawing.getFaceLengthHigh()));

			drawing.setCustomer(drawing.getCustomer());
			drawing.setOem(drawing.getOem());
			drawing.setBearingMin(drawing.getBearingMin());
			drawing.setBearingMax(drawing.getBearingMax());
			drawing.setCustomerPin(drawing.getCustomerPin());
			drawing.setCustomerRevision(drawing.getCustomerRevision());
			drawing.setDate(drawing.getDate());
			drawing.setDateCreated(drawing.getDateCreated());
			drawing.setNewBasePrice(drawing.getNewBasePrice());
			drawing.setOriginatingCustomer(drawing.getOriginatingCustomer());
			drawing.setPartNo(drawing.getPartNo());
			drawing.setPrevPartNo(drawing.getPrevPartNo());
			drawing.setProductCode(drawing.getProductCode());
			drawing.setRevNumber(drawing.getRevNumber());
			drawing.setSteps(drawing.getSteps());
			drawing.setSubcontractor(drawing.getSubcontractor());
			drawing.setType(drawing.getType());
		}
		return obj;
	}

	/**
	 * Cleans up a specified range of PrintDrawing objects.
	 *
	 * @param obj the list of PrintDrawing objects to be cleaned
	 * @return the cleaned list of PrintDrawing objects
	 */
	public static List<PrintDrawing> cleanUp(List<PrintDrawing> obj) {
		for (int i = 1; i < 11; i++) {
			PrintDrawing drawing = obj.get(i);

			drawing.setXlsmPath(cleanUpQuotes(drawing.getXlsmPath()));
			drawing.setXlsxPath(cleanUpQuotes(drawing.getXlsxPath()));
			drawing.setPdfPath(cleanUpQuotes(drawing.getPdfPath()));
			drawing.setScannedPath(cleanUpQuotes(drawing.getScannedPath()));
			drawing.setDmgDrawingPath(cleanUpQuotes(drawing.getDmgDrawingPath()));
			drawing.setDrawingName(cleanUpQuotes(drawing.getDrawingName()));
			drawing.setDiameterLow(cleanUpQuotes(drawing.getDiameterLow()));
			drawing.setDiameterHigh(cleanUpQuotes(drawing.getDiameterHigh()));
			drawing.setFaceLengthLow(cleanUpQuotes(drawing.getFaceLengthLow()));
			drawing.setFaceLengthHigh(cleanUpQuotes(drawing.getFaceLengthHigh()));
			drawing.setCustomer(cleanUpQuotes(drawing.getCustomer()));
			drawing.setOem(cleanUpQuotes(drawing.getOem()));
			drawing.setBearingMin(cleanUpQuotes(drawing.getBearingMin()));
			drawing.setBearingMax(cleanUpQuotes(drawing.getBearingMax()));
			drawing.setCustomerPin(cleanUpQuotes(drawing.getCustomerPin()));
			drawing.setCustomerRevision(cleanUpQuotes(drawing.getCustomerRevision()));
			drawing.setDate(cleanUpQuotes(drawing.getDate()));
			drawing.setDateCreated(cleanUpQuotes(drawing.getDateCreated()));
			drawing.setNewBasePrice(cleanUpQuotes(drawing.getNewBasePrice()));
			drawing.setOriginatingCustomer(cleanUpQuotes(drawing.getOriginatingCustomer()));
			drawing.setPartNo(cleanUpQuotes(drawing.getPartNo()));
			drawing.setPrevPartNo(cleanUpQuotes(drawing.getPrevPartNo()));
			drawing.setProductCode(cleanUpQuotes(drawing.getProductCode()));
			drawing.setRevNumber(cleanUpQuotes(drawing.getRevNumber()));
			drawing.setSteps(cleanUpQuotes(drawing.getSteps()));
			drawing.setSubcontractor(cleanUpQuotes(drawing.getSubcontractor()));
			drawing.setType(cleanUpQuotes(drawing.getType()));
		}
		return obj;
	}

	public static String countNumberChar(String temp) {

		if (temp.length() >= 5) {
			return temp;
		} else {
			temp = temp + "00000000";

			return temp;
		}
	}

	/**
	 * Converts a list of PrintDrawing objects to a list of PrintDrawingDto objects.
	 *
	 * @param obj the list of PrintDrawing objects to be converted
	 * @return the list of converted PrintDrawingDto objects
	 */
	public static List<PrintDrawingDto> convertObj(List<PrintDrawing> obj) {
		List<PrintDrawingDto> aniloxRollListDto = new ArrayList<>();

		for (int i = 1; i < obj.size(); i++) {
			PrintDrawingDto objDto = new PrintDrawingDto();

			objDto.setBearingMax(obj.get(i).getBearingMax());
			objDto.setXlsmPath(obj.get(i).getXlsmPath());
			objDto.setXlsxPath(obj.get(i).getXlsxPath());
			objDto.setPdfPath(obj.get(i).getPdfPath());
			objDto.setScannedPath(obj.get(i).getScannedPath());
			objDto.setDmgDrawingPath(obj.get(i).getDmgDrawingPath());
			objDto.setDrawingName(obj.get(i).getDrawingName());
			objDto.setDiameterLow(Float.parseFloat(
					countNumberChar((obj.get(i).getDiameterLow().trim())).substring(0, 4)));
			objDto.setDiameterHigh(Float.parseFloat(
					countNumberChar(obj.get(i).getDiameterHigh().trim()).substring(0, 4)));
			objDto.setFaceLengthLow(Float.parseFloat(
					countNumberChar(obj.get(i).getFaceLengthLow().trim()).substring(0, 4)));
			objDto.setFaceLengthHigh(Float.parseFloat(
					countNumberChar(obj.get(i).getFaceLengthHigh().trim()).substring(0, 4)));
			objDto.setCustomer(obj.get(i).getCustomer());
			objDto.setOem(obj.get(i).getOem());
			objDto.setBearingMin(obj.get(i).getBearingMin());
			objDto.setBearingMax(obj.get(i).getBearingMax());
			objDto.setCustomerPin(obj.get(i).getCustomerPin());
			objDto.setCustomerRevision(obj.get(i).getCustomerRevision());
			objDto.setDate(obj.get(i).getDate());
			objDto.setDateCreated(obj.get(i).getDateCreated());
			objDto.setNewBasePrice(obj.get(i).getNewBasePrice());
			objDto.setOriginatingCustomer(obj.get(i).getOriginatingCustomer());
			objDto.setPartNo(obj.get(i).getPartNo());
			objDto.setPrevPartNo(obj.get(i).getPrevPartNo());
			objDto.setProductCode(obj.get(i).getProductCode());
			objDto.setRevNumber(obj.get(i).getRevNumber());
			objDto.setSteps(obj.get(i).getSteps());
			objDto.setSubcontractor(obj.get(i).getSubcontractor());
			objDto.setType(obj.get(i).getType());

			aniloxRollListDto.add(objDto);
		}

		return aniloxRollListDto;
	}

	public static String forBlank(String obj) {

		if (obj.isBlank()) {
			obj = "NONE";

		}

		return obj;
	}

	public static List<PrintDrawingDto> convertObjNone(List<PrintDrawingDto> oldObjectDto) {
		List<PrintDrawingDto> aniloxRollListDto = new ArrayList<>();

		for (int i = 1; i < oldObjectDto.size(); i++) {
			PrintDrawingDto objDto = new PrintDrawingDto();

			objDto.setBearingMax(forBlank(oldObjectDto.get(i).getBearingMax()));
			objDto.setXlsmPath(forBlank(oldObjectDto.get(i).getXlsmPath()));
			objDto.setXlsxPath(forBlank(oldObjectDto.get(i).getXlsxPath()));
			objDto.setPdfPath(forBlank(oldObjectDto.get(i).getPdfPath()));
			objDto.setScannedPath(forBlank(oldObjectDto.get(i).getScannedPath()));
			objDto.setDmgDrawingPath(forBlank(oldObjectDto.get(i).getDmgDrawingPath()));
			objDto.setDrawingName(forBlank(oldObjectDto.get(i).getDrawingName()));
			objDto.setDiameterLow(oldObjectDto.get(i).getDiameterLow());
			objDto.setDiameterHigh(oldObjectDto.get(i).getDiameterHigh());
			objDto.setFaceLengthLow(oldObjectDto.get(i).getFaceLengthLow());
			objDto.setFaceLengthHigh(oldObjectDto.get(i).getFaceLengthHigh());
			objDto.setCustomer(forBlank(oldObjectDto.get(i).getCustomer()));
			objDto.setOem(forBlank(oldObjectDto.get(i).getOem()));
			objDto.setBearingMin(forBlank(oldObjectDto.get(i).getBearingMin()));
			objDto.setBearingMax(forBlank(oldObjectDto.get(i).getBearingMax()));

			objDto.setCustomerPin(forBlank(oldObjectDto.get(i).getCustomerPin()));
			objDto.setCustomerRevision(forBlank(oldObjectDto.get(i).getCustomerRevision()));
			objDto.setDate(forBlank(oldObjectDto.get(i).getDate()));
			objDto.setDateCreated(forBlank(oldObjectDto.get(i).getDateCreated()));
			objDto.setNewBasePrice(forBlank(oldObjectDto.get(i).getNewBasePrice()));
			objDto.setOriginatingCustomer(forBlank(oldObjectDto.get(i).getOriginatingCustomer()));
			objDto.setPartNo(forBlank(oldObjectDto.get(i).getPartNo()));
			objDto.setPrevPartNo(forBlank(oldObjectDto.get(i).getPrevPartNo()));
			objDto.setProductCode(forBlank(oldObjectDto.get(i).getProductCode()));
			objDto.setRevNumber(forBlank(oldObjectDto.get(i).getRevNumber()));
			objDto.setSteps(forBlank(oldObjectDto.get(i).getSteps()));
			objDto.setSubcontractor(forBlank(oldObjectDto.get(i).getSubcontractor()));
			objDto.setType(forBlank(oldObjectDto.get(i).getType()));

			aniloxRollListDto.add(objDto);
		}
		return aniloxRollListDto;
	}

	/**
	 * Method to write SQL script to a text file.
	 *
	 * @param masterSQLScript List of SQL script lines to be written to the file
	 */
	public static void writeSQLScript(List<String> masterSQLScript) {

		// Create New File Method

		createNewFile();
		int i = 1;
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter("PrintDrawings.sql"));

			while (i < masterSQLScript.size() - 1) {

				writer.write(masterSQLScript.get(i).toString());

				writer.newLine();

				i++;
			}

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Cleans up all fields in a list of PrintDrawing objects.
	 *
	 * @param obj List of PrintDrawing objects to be cleaned up
	 * @return Cleaned up list of PrintDrawing objects
	 */
	public static List<PrintDrawing> cleanUpAll(List<PrintDrawing> obj) {
		String fillword = "NONE";

		for (int i = 1; i < obj.size(); i++) {
			PrintDrawing drawing = obj.get(i);
			// Clean up each field in the PrintDrawing object
			drawing.setBearingMax(cleanUpQuotes(drawing.getBearingMax()));
			drawing.setBearingMin(cleanUpQuotes(drawing.getBearingMin()));
			drawing.setCustomer(cleanUpQuotes(drawing.getCustomer()));
			drawing.setCustomerPin(cleanUpQuotes(drawing.getCustomerPin()));
			drawing.setCustomerRevision(cleanUpQuotes(drawing.getCustomerRevision()));
			drawing.setDate(cleanUpQuotes(drawing.getDate()));
			drawing.setDateCreated(cleanUpQuotes(drawing.getDateCreated()));
			drawing.setDiameterLow(removeCharacters(cleanUpQuotes(drawing.getDiameterLow())));
			drawing.setDiameterHigh(removeCharacters(cleanUpQuotes(drawing.getDiameterHigh())));
			drawing.setDmgDrawingPath(fillword);
			drawing.setDrawingName(cleanUpQuotes(drawing.getDrawingName()));
			drawing.setFaceLengthLow(removeCharacters(cleanUpQuotes(drawing.getFaceLengthLow())));
			drawing.setFaceLengthHigh(removeCharacters(cleanUpQuotes(drawing.getFaceLengthHigh())));
			drawing.setNewBasePrice(cleanUpQuotes(drawing.getNewBasePrice()));
			drawing.setOem(cleanUpQuotes(drawing.getOem()));
			drawing.setOriginatingCustomer(cleanUpQuotes(drawing.getOriginatingCustomer()));
			drawing.setPartNo(cleanUpQuotes(drawing.getPartNo()));
			drawing.setPdfPath(cleanUpQuotes(drawing.getPdfPath()));
			drawing.setPrevPartNo(cleanUpQuotes(drawing.getPrevPartNo()));
			drawing.setProductCode(cleanUpQuotes(drawing.getProductCode()));
			drawing.setRevNumber(cleanUpQuotes(drawing.getRevNumber()));
			drawing.setScannedPath(fillword);
			drawing.setSteps(cleanUpQuotes(drawing.getSteps()));
			drawing.setSubcontractor(cleanUpQuotes(drawing.getSubcontractor()));
			drawing.setType(cleanUpQuotes(drawing.getType()));
			drawing.setXlsmPath(cleanUpQuotes(fillword));
			drawing.setXlsxPath(cleanUpQuotes(fillword));
		}
		return obj;
	}

	/**
	 * Removes non-numeric characters and formats a string.
	 *
	 * @param obj The string to be cleaned up
	 * @return The cleaned up string
	 */
	public static String removeHashes(String obj) {

		;
		String temp = "";
		char[] objChar = obj.toCharArray();

		obj = obj.toUpperCase();

		obj = obj.replaceAll("[^\\d.]", "");

		if (obj.equals("")) {
			obj = obj.replaceAll("", "00.00");
		}

		char[] objCharList = obj.toCharArray();

		int countPeriod = 0;
		for (int i = 0; i < objCharList.length; i++) {

			if (countPeriod == 1 && objCharList[i] == '.') {
				objCharList[i] = '0';
			}

			if (objCharList[i] == '.') {
				countPeriod++;
			}

		}
		obj = new String(objCharList);

		if (obj.length() > 5) {
			obj = obj.substring(0, 5);
		}

		return obj;
	}

	// the split() method splits the list of Strings "strList" into an array of
	// Strings called arrOfStr
	public static List<String[]> splitStringList(List<String> strList, List<String[]> strListB) {
		// System.out.println("splitStringList()...................");
		// System.out.println("*** Press Enter ***");
		// ;
		for (String x : strList) {

			String[] arrOfStr = x.split(",", -2);

			// the array of Strings "arrOfStr" is added as a single element in the
			// ArrayList<String[]> strListB
			strListB.add(arrOfStr);

		}
		return strListB;

	}

	public static String splitStringListStr(String temp1) {
		// System.out.println("splitStringList()...................");
		// System.out.println("*** Press Enter ***");
		// ;

		String[] temp2 = temp1.split(",", -2);

		String temp3 = temp2[0];

		return temp3;

	}

	// Method to create new file
	public static void createNewFile() {
		try {
			File myObj = new File("PrintDrawings.txt");

			if (myObj.createNewFile()) {
				System.out.println("File successfully created :)");
			} else {
				System.out.println("File already Exists");
			}

		} catch (IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}

	public static void deleteFile() {
		try {
			Path fileToDeletePath = Paths.get("PrintDrawings.txt");
			Files.delete(fileToDeletePath);

		} catch (IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}

	// Method to create String list
	public static List<String> createStrList(List<String> strList) {
		// System.out.println("createStrList().........");
		// System.out.println("*** Press Enter ***");
		// ;

		// Streams allow us to process data in a clear and concise way
		FileReader fd = null;
		String line = "";

		try {

			// Get the class loader
			ClassLoader classLoader = DataTools.class.getClassLoader();

			// Get the resource as an InputStream
			InputStream inputStream = classLoader
					.getResourceAsStream("resources/PrintDrawings.csv");

			// Use the InputStream to read the CSV data (e.g., with Apache Commons CSV)

			fd = new FileReader("PrintDrawings.csv");

			BufferedReader reader = new BufferedReader(fd);

			// readLine() --> reads each line of text and terminates when it
			// reaches the
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

		// for (int k = 0; k < 50; k++) {
		// System.out.println(strList.get(k).toString());
		// }

		return strList;
	}

	/**
	 * Method to track the values of elements in lists as we loop through them.
	 *
	 * @param strList  List of strings to track
	 * @param strListB List of string arrays to track
	 * @param k        Index of the string array element to track
	 * @param i        Index of the string to track
	 */
	public static void trackVariableValues(List<String> strList, List<String[]> strListB, int k,
			int i) {
		System.out.println("k = " + k);
		System.out.println("strList.get(" + i + ")= " + strList.get(i));
		System.out.println("strListB.get(" + i + ")[" + k + "] = " + strListB.get(i)[k]);
		System.out.println();
	}

	/**
	 * Method to write a list of PrintDrawing objects to a text file.
	 *
	 * @param aniloxRollList List of PrintDrawing objects to be written to the file
	 */
	public static void writeStrListToFileFinal01(List<PrintDrawing> printDrawingList) {

		int headerRowIndex = 0;
		System.out.println("writeStrListToFileFinal().........");
		System.out.println("Press Enter");

		FileWriter fw = null;
		String line = "";

		deleteFile();
		System.out.println("file deleted.........");
		System.out.println("Press Enter");
		createNewFile();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("PrintDrawings.txt"))) {

			if (printDrawingList.isEmpty()) {
				return;
			}

			if (writer != null) {
				if (headerRowIndex == 0) {
					// Write header row
					writer.write(String.format("%-100S", "Bearing Max") + "\t");
					writer.write(String.format("%-100S", "Bearing Min") + "\t");
					writer.write(String.format("%-100S", "Cust") + "\t");
					writer.write(String.format("%-100S", "Cust Pin") + "\t");
					writer.write(String.format("%-100S", "Cust Rev") + "\t");
					writer.write(String.format("%-100S", "Date") + "\t");
					writer.write(String.format("%-100S", "Date Created") + "\t");
					writer.write(String.format("%-100S", "Dia 1") + "\t");
					writer.write(String.format("%-100S", "Dia 2") + "\t");
					writer.write(String.format("%-100S", "Dmg Drawing Path") + "\t");
					writer.write(String.format("%-100S", "Drawing Name") + "\t");
					writer.write(String.format("%-100S", "Face 1") + "\t");
					writer.write(String.format("%-100S", "Face 2") + "\t");
					writer.write(String.format("%-100S", "New Base Price") + "\t");
					writer.write(String.format("%-100S", "OEM") + "\t");
					writer.write(String.format("%-100S", "Originating Customer") + "\t");
					writer.write(String.format("%-100S", "Part No") + "\t");
					writer.write(String.format("%-100S", "PDF Path") + "\t");
					writer.write(String.format("%-100S", "Prev Part No") + "\t");
					writer.write(String.format("%-100S", "Product Code") + "\t");
					writer.write(String.format("%-100S", "Rev Number") + "\t");
					writer.write(String.format("%-100S", "Scanned Path") + "\t");
					writer.write(String.format("%-100S", "Steps") + "\t");
					writer.write(String.format("%-100S", "Subcontractor") + "\t");
					writer.write(String.format("%-100S", "Type") + "\t");
					writer.write(String.format("%-100S", "XLSM Path") + "\t");
					writer.write(String.format("%-100S", "XLSX Path") + "\t");
					writer.newLine();
					headerRowIndex++;
				}

				for (int k = 1; k < printDrawingList.size(); k++) {
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getBearingMax().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getBearingMin().trim()));
					writer.write(
							String.format("%-100S", printDrawingList.get(k).getCustomer().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getCustomerPin().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getCustomerRevision().trim()));
					writer.write(String.format("%-100S", printDrawingList.get(k).getDate().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getDateCreated().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getDiameterLow().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getDiameterHigh().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getDmgDrawingPath().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getDrawingName().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getFaceLengthLow().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getFaceLengthHigh().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getNewBasePrice().trim()));
					writer.write(String.format("%-100S", printDrawingList.get(k).getOem().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getOriginatingCustomer().trim()));
					writer.write(
							String.format("%-100S", printDrawingList.get(k).getPartNo().trim()));
					writer.write(
							String.format("%-100S", printDrawingList.get(k).getPdfPath().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getPrevPartNo().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getProductCode().trim()));
					writer.write(
							String.format("%-100S", printDrawingList.get(k).getRevNumber().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getScannedPath().trim()));
					writer.write(
							String.format("%-100S", printDrawingList.get(k).getSteps().trim()));
					writer.write(String.format("%-100S",
							printDrawingList.get(k).getSubcontractor().trim()));
					writer.write(String.format("%-100S", printDrawingList.get(k).getType().trim()));
					writer.write(
							String.format("%-100S", printDrawingList.get(k).getXlsmPath().trim()));
					writer.write(
							String.format("%-100S", printDrawingList.get(k).getXlsxPath().trim()));
					writer.newLine();
				}
			}

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method to print all fields of a list of PrintDrawing objects.
	 *
	 * @param obj List of PrintDrawing objects to be printed
	 */
	public static void printAll(List<PrintDrawing> obj) {
		System.out.println("Printing...........");
		int headerRowIndex = 0;

		for (int i = 0; i < obj.size(); i++) {
			if (headerRowIndex == 0) {
				// Print header row
				System.out.print(String.format("%-100S", "XLSM Path"));
				System.out.print(String.format("%-100S", "XLSX Path"));
				// Continue for other fields...
				headerRowIndex++;
			}

			// Print data rows
			System.out.print(String.format("%-100S", obj.get(i).getXlsmPath()));
			System.out.print(String.format("%-100S", obj.get(i).getXlsxPath()));
			// Continue for other fields...
		}
	}

	/**
	 * Cleans up a string by removing certain characters.
	 *
	 * @param obj The string to be cleaned up
	 * @return The cleaned up string
	 */
	public static String cleanUpQuotes(String obj) {
		int count = 10;

		while (count < 11) {
			obj = obj.replaceAll("/", "");

			obj = obj.replaceAll("\'", "");
			obj = obj.replaceAll("\"", "");
			obj = obj.replaceAll("`", "");
			obj = obj.replaceAll("\'", "");
			count++;
		}

		return obj;
	}

	/**
	 * Removes alphabetic characters from a string.
	 *
	 * @param obj The string to be cleaned up
	 * @return The cleaned up string
	 */
	public static String removeCharacters(String obj) {
		return obj.replaceAll("[a-zA-Z]", "");
	}

}

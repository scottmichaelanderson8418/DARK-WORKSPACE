package com.zzzzzz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		// Hashmap for the students and their courses
		// Student number (id) is the key
		// ArrayList is their list of courses
		HashMap<Integer, ArrayList<String>> students = new HashMap<Integer, ArrayList<String>>();

		int studentNumber = 0;
		String courseNumber = "";
		String repeat = "";
		String entry = "";

		do {
			// get the inputs of the courses
			entry = getEntry();

			// Create an jarray to allow storage of the student id and course number
			// splits the entry by a space
			// puts the student id into index 0
			// puts the course number into index 1
			String entries[] = entry.split(" ");

			studentNumber = Integer.parseInt(entries[0]);

			courseNumber = entries[1];

			// build the hashMap
			if (students.containsKey(studentNumber)) {

				System.out.println(" check to see if id is a key that is already in the hashmap");
				// check to see if id is a key that is already in the hashmap
				// get the ArrayList associated with the key

				ArrayList<String> courses = students.get(studentNumber);
				// then add the course to the ArrayList
				courses.add(entries[1]);

				// then update the HashMap using the .replace() method
				students.replace(studentNumber, courses);

			} else {
				System.out
						.println("check to see if the id is not a key that exists in the hashmap");

				ArrayList<String> courses = new ArrayList<String>();
				// check to see if the id is not a key that exists in the hashmap
				// make a new ArrayList

				// add the course to the ArrayList
				courses.add(entries[1]);

				// use .put() method to add the student id and course ArrayList to the HashMap
				students.put(studentNumber, courses);
			}

			// ask the user to enter another course
			repeat = repeatEntry();

		} while (repeat.equalsIgnoreCase("Yes") || repeat.equalsIgnoreCase("y"));

		// display the contents of the hashMap
		System.out.println("\n");
		System.out.println(students);
		System.out.println();

	}

	// method gets the value of repeat

	public static String repeatEntry() {

		String repeat = "";
		System.out.println("Enter Y or Yes to Continue, Enter N or No to stop: ");
		repeat = keyboard.nextLine();

		while (!repeat.equalsIgnoreCase("no") && !repeat.equalsIgnoreCase("y") &&
				!repeat.equalsIgnoreCase("Yes") && !repeat.equalsIgnoreCase("n")) {
			System.out.println("\n\nERROR: Invalid choice entered. Try again. \n\n");
			System.out.println("Enter Y or Yes to Continue, Enter N or No to stop");
			repeat = keyboard.nextLine();

		}

		return repeat;

	}

	// method that validates the entry of a student id and a course
	public static String getEntry() {

		String entry = "";

		// get input of the student if and the course number
		System.out.println("Enter the student number and course number separated by a space: \n");

		System.out.println("\n\tExample: 1 CS100 \n\tExample: 2 MATH210 \n\n");

		System.out.print("Your Entry: ");

		entry = keyboard.nextLine();

		// create an array to allow storage of the course number and student id
		String[] entries = entry.split(" ");

		while (entries.length != 2) {
			System.out.println(
					"\n\nError: Invalid student number and course entered. Try again. \n\n");

			System.out
					.println("Enter the student number and course number separated by a space: \n");

			System.out.println("\n\tExample: 1 CS100 \n\tExample: 2 MATH210 \n\n");
			System.out.print("Your entry: ");
			entry = keyboard.nextLine();
			entries = entry.split(" ");

		}

		while (isNumeric(entries[0]) == false) {
			System.out.println(
					"\n\nError: Invalid student number and course entered. Try again. \n\n");
			System.out
					.println("Enter the student number and course number separated by a space: \n");
			System.out.println("\n\tExample: 1 CS100 \n\tExample: 2 MATH210 \n\n");
			System.out.print("Your entry: ");
			entry = keyboard.nextLine();
			entries = entry.split(" ");

		}
		return entry;
	}

	public static boolean isNumeric(String strNum) {

		if (strNum == null) {

			return false;
		}
		try {
			int d = Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;

	}
}

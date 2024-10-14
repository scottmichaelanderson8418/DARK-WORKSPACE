package com.practice01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Throw exceptions in the following cases:

		// 1. The apartment number does not consist of three digits
		// 2. The number of bedrooms is less than 1 or greater than 4
		// 3. The rent is outside of the range of $500 to $2500

		Scanner scanner = new Scanner(System.in);

		Apartment apartmentObj = new Apartment();

		System.out.println("Apartment Specifications: \n");

		// System.out.print("Enter the street address: ");
		//
		// apartmentObj.setStreetAddress(scanner.nextLine());

		/*
		 * Note: when we use the Try / catch statement the program is able to continue
		 * on because the exception is absorbed by the compiler
		 */

		// Note: There are two types of throwables
		// 1. Exceptions
		// 2. Errors
		// Generally you do not want to "catch" all throwables because you don't want to
		// catch errors

		// Its important to have the try catch in the method that is catching the
		// exception

		// ---------------------------
		String apartmentNumber = "";

		try {

			System.out.print("Enter the apartment number: ");

			// apartmentObj.setApartmentNumber(Integer.parseInt(scanner.nextLine()));

			apartmentNumber = scanner.nextLine();

			if (isValidApartmentNumber(apartmentNumber)) {

				System.out.println("The apartmentNumber is valid");

				// apartmentObj.setApartmentNumber(apartmentNumber);

			}

			// scanner.nextLine();

		} catch (ApartmentException apartmentException) {

			System.out.println("***ApartmentException Caught ***");

			System.out.println(apartmentException.getMessage());

		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());

		} catch (Exception e) {

			System.out.println("*** Exception ***");

			e.printStackTrace();
		}

		// ---------------------------

		int numberBedrooms;

		try {
			System.out.println("Enter the number of bedrooms: ");

			numberBedrooms = Integer.parseInt(scanner.nextLine());

			if (isValidNumberBedrooms(numberBedrooms)) {
				System.out.println("Number of bedrooms is valid");
			}

		} catch (NumberFormatException ee) {
			throw new NumberFormatException("Invalid input. Please enter a whole number.");

		} catch (ApartmentException eee) {

			System.out.println("***ApartmentException Caught ***");
			System.out.println(eee.getMessage());

		}

		// ---------------------------

		System.out.println("Enter the rent value: ");
		apartmentObj.setStreetAddress(scanner.nextLine());

		System.out.println("End of program");

	}

	public static boolean isValidApartmentNumber(String apartmentNumber)
			throws ApartmentException, InputMismatchException {

		int numberInt = 0;

		try {
			numberInt = Integer.parseInt(apartmentNumber);

		} catch (InputMismatchException e) {
			throw new InputMismatchException("*** INPUTMISMATCHEXCEPTION ***");
		}

		if (apartmentNumber.length() != 3) {

			throw new ApartmentException("Apartment Number does not consist of 3 digits");

		}

		return true;

	}

	public static boolean isValidNumberBedrooms(int numberBedrooms) throws ApartmentException {

		if (numberBedrooms < 1 || numberBedrooms > 4) {

			throw new ApartmentException("Bedroom number is less than 1 or greater than 4");

		}

		return true;

	}

}

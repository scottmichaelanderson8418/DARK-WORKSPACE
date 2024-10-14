

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Throw exceptions in the following cases:
		// 1. The apartment number does not consist of three digits
		// 2. The number of bedrooms is less than 1 or greater than 4
		// 3. The rent is outside of the range of $500 to $2500

		Scanner scanner = new Scanner(System.in);

		// create LinkedList of apartment objects
		List<Apartment> apartmentList = new LinkedList<>();

		// initialize boolean variables
		boolean booA = false;
		boolean booB = false;

		// outer while loop
		while (!booB) {

			booB = false;

			// inner while loop
			while (!booA) {

				// Create Apartment Object
				Apartment apartmentObj = new Apartment();

				System.out.print("Enter the street address: ");
				apartmentObj.setStreetAddress(scanner.nextLine());

				String apartmentStrTemp = "";

				// Ask user for the apartment number
				try {

					System.out.print("Enter the apartment number: ");

					apartmentStrTemp = scanner.nextLine();

					// 1. The apartment number does not consist of three digits
					if (isValidApartmentNumber(apartmentStrTemp)) {

						System.out.println(apartmentStrTemp + " is valid");

						apartmentObj.setApartmentNumber(Integer.parseInt(apartmentStrTemp));
					}

				} catch (ApartmentException apartmentException) {

					System.out.println("*** ApartmentException ***");

					System.out.println(apartmentException.getMessage());
					break;
				}

				String numberBedrooms;

				// Ask use for number of bedrooms
				try {

					System.out.print("Enter the number of bedrooms: ");

					numberBedrooms = scanner.nextLine();

					// 2. The number of bedrooms is less than 1 or greater than 4
					if (isValidNumberBedrooms(numberBedrooms)) {

						System.out.println(numberBedrooms + " is valid");

						// this will not return an exception because the number of bedrooms is a
						// valid
						// integer
						apartmentObj.setNumberOfBedRooms(Integer.parseInt(numberBedrooms));

					}
					// Catch the exception
				} catch (ApartmentException apartmentException) {

					System.out.println("*** ApartmentException ***");

					System.out.println(apartmentException.getMessage());

					break;
				}

				String rentValue = "";

				// Ask user for rent value
				try {

					System.out.print("Enter the rent value: ");

					rentValue = scanner.nextLine();

					// 3. The rent is outside of the range of $500 to $2500
					if (isValidRentValue(rentValue)) {

						System.out.println(Float.parseFloat(rentValue) + " is valid");

						apartmentObj.setRentValue(Integer.parseInt(rentValue));
					}

				} catch (ApartmentException apartmentException) {

					System.out.println("*** ApartmentException ***");

					System.out.println(apartmentException.getMessage());

					break;
				}

				// Add apartment object to apartmentList
				apartmentList.add(apartmentObj);

				break;
			}
			System.out.println();

			booA = toContinue(scanner);

			if (booA == true) {
				printApartmentObjects(apartmentList);
				booB = true;
			}

		}

		scanner.close();
	}

	// Print apartment objects
	public static void printApartmentObjects(List<Apartment> apartmentList) {

		for (int i = 0; i < apartmentList.size(); i++) {

			System.out.println(apartmentList.get(i).toString());

		}

	}

	// Method to ask user to continue with program
	public static boolean toContinue(final Scanner scanner) {

		String input = "";

		System.out.print("Enter 'y' or 'yes' to continue, anything else to stop: ");

		input = scanner.nextLine();

		if (input.equals("y") || input.equals("yes")) {
			return false;
		}

		return true;

	}

	// Method for validating apartment number
	public static boolean isValidApartmentNumber(String apartmentStrTemp)
			throws ApartmentException {

		int index = 0;

		// apartmentStrTemp does not consist of 3 characters or digits
		if (apartmentStrTemp.length() != 3) {

			throw new ApartmentException(
					"Invalid apartment number. Apartment object will not be created");

		}

		// loop through each character and verify it is an integer value
		while (index < 3) {

			if (!Character.isDigit(apartmentStrTemp.charAt(index))) {

				throw new ApartmentException(
						"Invalid apartment number. Apartment object will not be created");
			}
			index++;

		}

		return true;

	}

	// Method for validating number of bedrooms
	public static boolean isValidNumberBedrooms(String numberBedrooms) throws ApartmentException {

		int numberBedroomInt = 0;

		if (!isInteger(numberBedrooms)) {

			throw new ApartmentException(
					"Invalid number of beds. Apartment object will not be created");
		}

		numberBedroomInt = Integer.parseInt(numberBedrooms);

		if (numberBedroomInt < 1 || numberBedroomInt > 4) {

			throw new ApartmentException("Number of bedrooms is less than 1 or greater than 4");

		}

		return true;

	}

	// Method for validating rent value
	public static boolean isValidRentValue(String rentValue) throws ApartmentException {

		int rentValueInt = 0;

		if (!isInteger(rentValue)) {

			throw new ApartmentException(
					"Invalid rent amount. Apartment object will not be created");
		}

		rentValueInt = Integer.parseInt(rentValue);

		if (rentValueInt < 500 || rentValueInt > 2500) {

			throw new ApartmentException(
					"Invalid rent amount. Apartment object will not be created");

		}

		return true;

	}

	// Method for determining if value is an integer
	public static boolean isInteger(String stringValue) {

		if (stringValue.isEmpty() || stringValue == null) {
			return false;
		}

		for (int i = 0; i < stringValue.length(); i++) {

			if (i == 0 && stringValue.charAt(i) == '-') {

				if (stringValue.length() == 1) {
					return false;
				} else {
					continue;
				}
			}

			if (!Character.isDigit(stringValue.charAt(i))) {
				return false;
			}

		}

		return true;

	}

}

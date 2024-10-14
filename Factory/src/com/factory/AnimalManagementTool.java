package com.factory;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalManagementTool {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String animalName = getInput(scanner);

		Animal animal;

		animalName = findMatch(animalName);

		try {
			animal = AnimalFactory.getAnimal(animalName);
			animal.speak();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getInput(final Scanner scanner) {
		System.out.println("Which animal do you want to speak? ");
		String serverResult = scanner.nextLine();

		return serverResult;
	}

	public static String findMatch(String serverResult) {

		Pattern pattern1 = Pattern.compile("cow", Pattern.CASE_INSENSITIVE);
		Matcher matcher1 = pattern1.matcher(serverResult);
		boolean matchFound1 = matcher1.find();

		Pattern pattern2 = Pattern.compile("dog", Pattern.CASE_INSENSITIVE);
		Matcher matcher2 = pattern2.matcher(serverResult);
		boolean matchFound2 = matcher2.find();

		Pattern pattern3 = Pattern.compile("cat", Pattern.CASE_INSENSITIVE);
		Matcher matcher3 = pattern3.matcher(serverResult);
		boolean matchFound3 = matcher3.find();

		if (matchFound1) {
			System.out.println("Match found");
			return serverResult = "cow";
		} else if (matchFound2) {
			System.out.println("Match found");
			return serverResult = "dog";
		} else if (matchFound3) {
			System.out.println("Match found");
			return serverResult = "cat";
		} else {
			System.out.println("Match not found :(");
			getInput(scanner);
		}

		return serverResult;

	}

}

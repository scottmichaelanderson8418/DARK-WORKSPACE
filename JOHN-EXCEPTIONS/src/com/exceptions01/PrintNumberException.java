package com.exceptions01;

public class PrintNumberException {

	public static void main(String[] args) {

		System.out.println(printANumber());
	}

	private static int printANumber() {
		try {
			return 3;

		} catch (Exception e) {
			return 4;
		} finally {

			// avoid using return statement in your finally block
			return 5;
		}

	}

}

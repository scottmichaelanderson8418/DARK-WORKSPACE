package com.exceptions01;

public class ExceptionHandling {

	public static void main(String[] args) {

		try {

			getInt();

		} catch (NumberFormatException | NullPointerException e) {
			System.out.println("***NumberFormatException***");

			System.out.println("e.getMessage()= " + e.getMessage());

			System.out.println("e.getCause() = " + e.getCause());
			System.out.println("e.getClass() = " + e.getClass());
			System.out.print("e.printStackTrace() = ");
			e.printStackTrace();

			System.out.println("Hey dude, you can't make an int out");
		}

		catch (Exception allexceptions) {
			System.out.println("*** EXCEPTION ***");
			System.out.println("Hey dude, you can't make an int out");
			System.out.print("ee.printStackTrace() = ");
			allexceptions.printStackTrace();
		} finally {
			System.out.println("in the finally block :)");
		}

		System.out.println("End here");

	}

	private static void getInt() {
		int myInt = Integer.parseInt("HI");

	}

}

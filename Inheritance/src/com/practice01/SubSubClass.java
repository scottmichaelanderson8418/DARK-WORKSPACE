package com.practice01;

public class SubSubClass extends SubClass {
	static {
		System.out.println("*** static SubSubClass Class Entered ***");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new SubSubClass("ABC");

	}

	{
		System.out.println("*** SubSubClass Class Entered ***");
	}

	public SubSubClass(String s) {

		super();

		System.out.println("SubSubClass(String s) ");
	}

}

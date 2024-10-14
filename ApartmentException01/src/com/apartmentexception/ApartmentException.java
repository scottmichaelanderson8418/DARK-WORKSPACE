package com.apartmentexception;

public class ApartmentException extends Exception {

	public ApartmentException() {

		System.out.println("Apartment Exception was caught!!");

	}

	// Constructor receives a string that holds a custom exception and a default
	// constructor that does not
	public ApartmentException(String s) {

		super(s);
	}

}

package com.interfaces;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TaxCalculator calculator = getCalculator();

		calculator.calculateTax();
	}

	// Dependency injection framework will give us real implementations of the
	// interfaces
	public static TaxCalculator getCalculator() {
		return new TaxCalculator2019();
	}

}

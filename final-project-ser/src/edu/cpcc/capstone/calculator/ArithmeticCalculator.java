package edu.cpcc.capstone.calculator;

public class ArithmeticCalculator {
	
	
	public int add (int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}
	
	public int multiply (int firstNumber, int secondNumber) {
		return firstNumber * secondNumber;
	}
	
	public int divide (int firstNumber, int secondNumber) throws Exception {
		if(secondNumber != 0) { 
			return firstNumber / secondNumber;
		}
		else {
			throw new Exception ("Invalid denominator");
		}
	}

}

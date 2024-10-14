package edu.cpcc.capstone.calculator.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.cpcc.capstone.calculator.ArithmeticCalculator;

class TestArithmeticCalculator {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAdd() {
		ArithmeticCalculator calc = new ArithmeticCalculator();
		int firstNumber = 1;
		int secondNumber = 2;
		int expectedResult = 3;
		
		int actualResult = calc.add(firstNumber, secondNumber);
	    assertEquals(expectedResult, actualResult);		
		
	}
	
	
	@Test
	void testMultiply() {
		ArithmeticCalculator calc = new ArithmeticCalculator();
		int firstNumber = 2;
		int secondNumber = 2;
		int actualResult = calc.multiply(firstNumber, secondNumber);
		int expectedResult = 4;
		assertEquals(expectedResult, actualResult);		
	}
	
//	@Test
//	void testDivison() {
//		ArithmeticCalculator calc = new ArithmeticCalculator();
//		int firstNumber = 4;
//		int secondNumber = 2;
//		int actualResult = calc.divide(firstNumber, secondNumber);
//		int expectedResult = 2;
//		assertEquals(expectedResult, actualResult);		
//	}
	
	@Test
	void testDivisonByZero() {
		ArithmeticCalculator calc = new ArithmeticCalculator();
		int firstNumber = 4;
		int secondNumber = 0;
		
		try {
			int actualResult = calc.divide(firstNumber, secondNumber);			
		}catch (ArithmeticException e) {
			fail();			
		}
		catch (Exception e) {			
		}
		
	
	}
		

}

package com.CSC284;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.CSC284Scott.Circle;

class CircleTest {

	@Test
	void testGetArea() {
		// double piValue = 3.14159;
		Circle circle = new Circle(5);
		assertEquals(31.4159, circle.getCircumference(), 0.0001);
	}

	@Test
	void testGetDiameter() {
		Circle circle = new Circle(5);
		assertEquals(10, circle.getDiameter(), 0.0001);
	}

	@Test
	void testGetCircumference() {
		Circle circle = new Circle(5);
		double actual = circle.getCircumference();
		double expected = 10 * 3.14159;
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	void testGetPerimeter() {
		Circle circle = new Circle(5);
		double actual = circle.getPerimeter();
		double expected = 10 * 3.14159;
		assertEquals(expected, actual, 0.0001);
	}

}

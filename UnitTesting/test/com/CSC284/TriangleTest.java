package com.CSC284;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TriangleTest {

	@Test
	void testGetAreaBaseTimesHeightA() {
		Triangle triangle = new Triangle();
		triangle.setBase(20);
		triangle.setHeight(10);

		assertEquals(100.00, triangle.getArea(), 0.0001);
	}

	@Test
	void testGetAreaBaseTimesHeightB() {
		Triangle triangle = new Triangle();
		triangle.setBase(50);
		triangle.setHeight(20);

		assertEquals(500, triangle.getArea(), 0.0001);
	}

	@Test
	void testGetAreaBaseTimesHeightC() {
		Triangle triangle = new Triangle();
		triangle.setBase(20.345);
		triangle.setHeight(18.745);

		assertEquals(190.69, triangle.getArea(), 0.01);
	}

	@Test
	void testGetAreaSidesA() {
		Triangle triangle = new Triangle(4, 5, 6, 6, 3.3);

		double actual = triangle.getArea();

		double expected = 9.9;

		assertEquals(expected, actual, 0.0001);

	}

	@Test
	void testGetAreaSidesB() {
		Triangle triangle = new Triangle(18, 20, 22, 22, 15.427);

		assertEquals(169.697, triangle.getArea(), 0.0001);

	}

	@Test
	void testGetPerimeter() {
		Triangle triangle = new Triangle(5, 6, 7, 7, 4.199);

		assertEquals(18, triangle.getPerimeter(), 0.0001);

	}

	@Test
	void testIsNotEquilateral() {
		Triangle triangle = new Triangle();
		triangle.setSideA(5);
		triangle.setSideB(6);
		triangle.setSideC(7);

		assertFalse(triangle.isEquilateral());

	}

	@Test
	void testIsEquilateralOverloaded() {
		Triangle triangle = new Triangle(7, 7, 7, 7, 6.06218);

		assertTrue(triangle.isEquilateral());

	}

	@Test
	void testIsEquilateralDefaultConstructor() {
		Triangle triangle = new Triangle();
		triangle.setSideA(7);
		triangle.setSideB(7);
		triangle.setSideC(7);
		triangle.setBase(10);
		triangle.setHeight(20);
		assertTrue(triangle.isEquilateral());

	}

}

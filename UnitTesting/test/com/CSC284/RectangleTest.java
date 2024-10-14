package com.CSC284;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.CSC284Scott.Rectangle;

class RectangleTest {

	@Test
	void testGetArea() {
		Rectangle rect = new Rectangle(10, 20);
		assertEquals(200, rect.getArea());// the area of rect should be 200 (10 * 20)
	}

	@Test
	void testGetPerimeter() {
		Rectangle rect = new Rectangle(10, 20);
		double actual = rect.getPerimeter();
		double expected = 60;
		assertEquals(expected, actual);// the perimeter of rect should be 60 ( 2 (10 + 20))
	}

	@Test
	void testIsSquare() {
		Rectangle rect = new Rectangle(10, 20);
		assertFalse(rect.isSquare());// rect should not be a square

		Rectangle square = new Rectangle(10, 10);
		assertTrue(square.isSquare());// square should be a square
	}

}

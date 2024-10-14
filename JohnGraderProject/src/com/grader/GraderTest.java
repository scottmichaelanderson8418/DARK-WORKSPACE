package com.grader;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GraderTest {

	@Test
	void fiftyNineShouldReturnF() {
		Grader grader = new Grader();
		assertEquals('F', grader.determineLetterGrade(59));
	}

	@Test
	void sixtyOneShouldReturnD() {
		Grader grader = new Grader();
		assertEquals('D', grader.determineLetterGrade(61));
	}

	@Test
	void sixtyNineShouldReturnD() {
		Grader grader = new Grader();
		assertEquals('D', grader.determineLetterGrade(69));
	}

	@Test
	void seventyOneShouldReturnC() {
		Grader grader = new Grader();
		assertEquals('C', grader.determineLetterGrade(71));
	}

	@Test
	void seventyNineShouldReturnC() {
		Grader grader = new Grader();
		assertEquals('C', grader.determineLetterGrade(79));
	}

	@Test
	void eightyOneShouldReturnB() {
		Grader grader = new Grader();
		assertEquals('B', grader.determineLetterGrade(81));
	}

	@Test
	void eightyNineShouldReturnB() {
		Grader grader = new Grader();
		assertEquals('B', grader.determineLetterGrade(89));
	}

	@Test
	void ninetyOneShouldReturnA() {
		Grader grader = new Grader();
		assertEquals('A', grader.determineLetterGrade(91));
	}

	@Test
	void NinetyNineShouldReturnA() {
		Grader grader = new Grader();
		assertEquals('A', grader.determineLetterGrade(99));
	}

	@Test
	void zeroShouldReturnF() {
		Grader grader = new Grader();
		assertEquals('F', grader.determineLetterGrade(0));
	}

	@Test
	void negativeOneShouldReturnIllegalArgumentException() {
		Grader grader = new Grader();

		assertThrows(IllegalArgumentException.class, () -> {
			grader.determineLetterGrade(-1);
		});

	}

}

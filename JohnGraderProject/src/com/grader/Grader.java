package com.grader;

public class Grader {

	public char determineLetterGrade(int numberGrade) {

		if (numberGrade < 0) {
			throw new IllegalArgumentException("Number grade cannot be calculated");
			// return 'F';
		}
		if (numberGrade < 60) {
			return 'F';
		}
		if (numberGrade < 70) {
			return 'D';
		}
		if (numberGrade < 80) {
			return 'C';
		}
		if (numberGrade < 90) {
			return 'B';
		}
		return 'A';

	}

}

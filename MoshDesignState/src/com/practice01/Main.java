package com.practice01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Open Closed Principle
		// Open for extension
		// Closed for modification
		Canvas obj = new Canvas(new WhiteOut());

		obj.mouseUp();

		obj.mouseDown();

	}

}

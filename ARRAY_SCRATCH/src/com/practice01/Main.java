package com.practice01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ScottArray numbers = new ScottArray(2);

		numbers.insert(10);
		numbers.insert(20);
		numbers.insert(30);

		System.out.println(numbers.print());

		System.out.println(numbers.print());

		System.out.println(numbers.print());

		ScottArray02 scottList02 = new ScottArray02(2);

		scottList02.insert(20);

		scottList02.insert(60);

		scottList02.insert(80);
		//
		scottList02.insert(90);

		scottList02.insert(100);
		System.out.println(scottList02.print());

		scottList02.removeAt(5);

		System.out.println(scottList02.print());
		// int index = numbers.findIndexAtNumber(20);
		//
		// System.out.println(
		// "numbers.findIndexAtNumber(" + 20 + ") = " + numbers.findIndexAtNumber(20));
		//
		// System.out.println(
		// "numbers.findIndexAtNumber(" + -999 + ") = " +
		// numbers.findIndexAtNumber(-999));
		//
		//

	}
}

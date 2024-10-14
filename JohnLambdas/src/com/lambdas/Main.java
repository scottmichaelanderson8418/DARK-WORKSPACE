package com.lambdas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cat myCat = new Cat();

		// printThing(myCat);

		Printable lambdaPrintable = (p, s) -> "MEOW!!" + p + s;

		printThingA(lambdaPrintable);

	}

	static void printThingA(Printable thing) {

		System.out.println(thing.printA("Prefix", "Suffix"));

	}

}

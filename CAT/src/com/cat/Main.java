package com.cat;

public class Main {

	public static void main(String[] args) {
		// FIXME Auto-generated method stub

		Cat newCat = new Cat();
		// System.out.print("newCat.print(\"HI HI\") = ");
		// newCat.print("HI HI");
		//
		// System.out.print("printThing(newCat) = ");
		// printThing(newCat);
		//
		// /*
		// * Instead of passing in the object that contains the function, we are passing
		// * in the object itself
		// */

		// System.out.print("printThing((s) -> System.out.println(\"MEEEEOOOOW \" + s))
		// = ");

		Printable printableObject = printThing((s) -> {

			System.out.println("MEEEEOOOOW " + s);

			return "MEEEEOOOOW " + s;

		});

	}

	static void printThing(Printable thing) {
		thing.print("yeah");
	}

}

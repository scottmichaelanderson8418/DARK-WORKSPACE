package com.practice01;

public class OuterClass {

	int number = 6;

	public void herThere() {
		System.out.println("Hey there!");

		class LocalInnerClass {
			String localInnerClassVariable = "Here's Johnny";

			public void printLocalInnerClassVariable() {

				System.out.println("localInnerClassVariable= " + localInnerClassVariable);
			}
		}

		LocalInnerClass lic = new LocalInnerClass();

		lic.printLocalInnerClassVariable();

	}

	public static class InnerClass {

		int number = 8;

		public void whatsUp() {

			System.out.println("Whats up from the Inner Class");

		}
	}

}

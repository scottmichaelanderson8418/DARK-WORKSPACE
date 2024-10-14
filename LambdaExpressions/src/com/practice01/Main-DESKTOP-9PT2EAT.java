package com.practice01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Call the interface
		// Structure
		// Method(Parameters){ code};
		/* Lambdas can only be used with certain types of interfaces */

		FuncInterface fobj = (int x) -> System.out.println(2 * x);

		fobj.abstractFun(5);

		ScottClass obj = new ScottClass();

		// Because ScottClass implements the FuncInterface we can use the
		// "abstractFun()" method
		obj.abstractFun(6);

	}

}

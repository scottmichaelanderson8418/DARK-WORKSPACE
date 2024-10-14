package com.practice01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FuncInterface fobj = (int x) -> System.out.println(2 * x);

		fobj.abstractFun(5);

		ScottClass obj = new ScottClass();

		obj.abstractFun(6);

	}

}

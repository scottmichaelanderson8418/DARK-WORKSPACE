package com.practice01;

public interface FuncInterface {

	void abstractFun(int x);

	default void normalFun() {

		System.out.println("Hello");
	}

}

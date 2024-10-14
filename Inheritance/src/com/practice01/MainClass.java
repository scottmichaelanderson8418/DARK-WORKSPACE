package com.practice01;

public class MainClass {
	static {
		System.out.println("*** static Main Class Entered ***");
	}
	{
		System.out.println("*** Main Class Entered ***");
	}

	MainClass() {
		System.out.println("MainClass");

	}
}

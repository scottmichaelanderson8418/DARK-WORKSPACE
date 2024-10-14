
package com.practice01;

public class SubClass extends MainClass {
	static {
		System.out.println("*** static SubClass Class Entered ***");
	}
	// this is a static initializer block. It is execute only once when the class is
	// first loaded
	static {
		System.out.println("S ");
	}

	{
		System.out.println("*** SubClass Class Entered ***");
	}

	// this is an instance initializer block. It is executed each time an instance
	// of a class is created
	{
		System.out.println("I");

	}

	public SubClass() {
		super();
		System.out.println("SubClass()");
	}

	public SubClass(int i) {
		this();
		System.out.println("SubClass(int i)");
	}

	public void print() {
		System.out.println("*** ENTER SubClass ***");
	}
}

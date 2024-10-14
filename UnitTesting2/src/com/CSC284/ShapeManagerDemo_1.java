package com.CSC284;

/**
 * 
 * This demo program just creates a ShapeManager object and adds some shapes to
 * it to show how the different Shape class and the ShapeManager class work
 *
 */
public class ShapeManagerDemo {

	public static void main(String[] args) {

		// Create a ShapeManager
		ShapeManager sm = new ShapeManager();

		// add some Shapes to manage
		sm.add(new Circle(5));
		sm.add(new Rectangle(10, 8));
		sm.add(new Triangle(3, 4, 5, 3, 4));

		// display the shapes
		sm.display();
	}

}

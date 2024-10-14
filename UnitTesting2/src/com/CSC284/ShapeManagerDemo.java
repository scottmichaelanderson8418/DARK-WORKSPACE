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

		Triangle triangleA = new Triangle(10, 10, 10, 10, 8.660254038);
		sm.add(triangleA);

		Triangle triangleB = new Triangle();
		triangleB.setBase(10);
		triangleB.setHeight(20);

		System.out.println("triangleB.getArea()= " + triangleB.getArea());
		sm.add(triangleB);

		// display the shapes
		sm.display();

		// System.out.println(triangle.getSideA());

		// System.out.println("triangle.getArea() = " + triangle.getArea());
	}

}

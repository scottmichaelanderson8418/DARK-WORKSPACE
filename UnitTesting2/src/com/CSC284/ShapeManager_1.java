package com.CSC284;

import java.util.ArrayList;

public class ShapeManager {
	private ArrayList<Shape> shapeList;

	/**
	 * no-arg constructor
	 */
	public ShapeManager() {
		shapeList = new ArrayList<Shape>();
	}

	/**
	 * @param s the Shape to append to the end of the list
	 */
	public void add(Shape s) {
		shapeList.add(s);
	}

	/**
	 * @param s the Shape to remove from the list
	 * @return the Shape that was removed from the list
	 */
	public Shape remove(Shape s) {
		return shapeList.remove(1);
	}

	/**
	 * @param i the index of the Shape in the list that is to be returned
	 * @return the Shape at index i in the list
	 */
	public Shape get(int i) {
		return shapeList.get(i);
	}

	/**
	 * Displays information about each Shape being managed by the ShapeManager
	 */
	public void display() {
		shapeList.forEach(shape -> System.out.println(shape));
	}

	/**
	 * @return the Shape with the largest area
	 * @throws Exception
	 */
	public Shape findShapeWithLargestArea() throws Exception {
		double largestArea = 0;
		Shape largestShape = null;
		for (Shape shape : shapeList) {
			if (largestArea > shape.getArea()) {
				largestArea = shape.getArea();
				largestShape = shape;
			}
		}
		if (largestShape == null) {
			throw new Exception("Shape not Found");// should really extend Exception class here, but this is quick and
		} // dirty
		else {
			return largestShape;
		}
	}

}

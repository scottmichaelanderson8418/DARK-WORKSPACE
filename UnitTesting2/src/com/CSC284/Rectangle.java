package com.CSC284;

public class Rectangle implements Shape {

	private double length;
	private double width;

	/**
	 * Constructor that initializes length and width of the Rectangle to the values
	 * of the arguments it is passed
	 * 
	 * @param length the length
	 * @param width  the width
	 */
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	/**
	 * no-arg constructor that initializes the length and width of the Rectangle to
	 * 0
	 */
	public Rectangle() {
		length = 0.0;
		width = 0.0;
	}

	/**
	 * Sets the length of the Rectangle
	 * 
	 * @param length the length
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return the length of the Rectangle
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Sets the width of the Rectangle
	 * 
	 * @param width the length
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the width of the Rectangle
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @return the area of the Rectangle
	 */
	public double getArea() {
		return length * width;
	}

	/**
	 * @return the perimeter of the Rectangle
	 */
	public double getPerimeter() {
		return 2 * (length * width);
	}

	/**
	 * @return true if the Rectangle is a square. The Rectangle is a square if the
	 *         length and width are equal.
	 */
	public boolean isSquare() {
		return length == width;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + ", getArea()=" + getArea() +
				", getPerimeter()=" + getPerimeter() + "]";
	}

}

package com.CSC284;

public class Circle implements Shape {

	private final double PI = 3.14159;

	private double radius;

	/**
	 * no-arg constructor that initializes the radius of the Circle to 0
	 */
	public Circle() {
		radius = 0.0;
	}

	/**
	 * Constructor that initializes radius of the Circle to the value of the
	 * argument it is passed
	 * 
	 * @param radius the radius
	 */
	public Circle(double radius) {
		this.radius = radius;
	}

	/**
	 * @return the area of the Circle
	 */
	public double getArea() {
		return PI * radius;
	}

	/**
	 * @return the circumference of the Circle
	 */
	public double getCircumference() {
		return 2 * PI * radius;
	}

	/**
	 * @return the diameter of the Circle
	 */
	public double getDiameter() {
		return radius * 2;
	}

	/**
	 * Adheres to Shape interface by implementing thus method - which just calls
	 * getCircumference since the circumference of a circle is the "perimeter"
	 * 
	 * @return the "perimeter" of the Circle
	 */
	public double getPerimeter() {
		return getCircumference();
	}

	/**
	 * @return the radius of the Circle
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Sets the radius of the Circle
	 * 
	 * @param radius the radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", getArea()=" + getArea() + ", getPerimeter()=" +
				getPerimeter() + "]";
	}

}

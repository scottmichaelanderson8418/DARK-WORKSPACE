package com.CSC284;

public class Triangle implements Shape {

	private double sideA;
	private double sideB;
	private double sideC;
	private double base;
	private double height;

	/**
	 * Constructor that initializes fields of the Triangle to the values of the
	 * arguments it is passed
	 * 
	 * @param sideA  the length of side A
	 * @param sideA  the length of side B
	 * @param sideA  the length of side C
	 * @param length the base
	 * @param width  the height
	 */
	public Triangle(double sideA, double sideB, double sideC, double base, double height) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		this.base = base;
		this.height = height;
	}

	/**
	 * no-arg constructor that initializes the length and width of the Triangle to 0
	 */
	public Triangle() {
		base = 0.0;
		height = 0.0;
	}

	/**
	 * Sets the length of side A of the Triangle
	 * 
	 * @param base the base
	 */
	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	/**
	 * @return the length of side A of the Triangle
	 */
	public double getSideA() {
		return sideA;
	}

	/**
	 * Sets the length of side B of the Triangle
	 * 
	 * @param base the base
	 */
	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	/**
	 * @return the length of side B of the Triangle
	 */
	public double getSideB() {
		return sideB;
	}

	/**
	 * Sets the length of side C of the Triangle
	 * 
	 * @param base the base
	 */
	public void setSideC(double sideC) {
		this.sideC = sideC;
	}

	/**
	 * @return the length of side C of the Triangle
	 */
	public double getSideC() {
		return sideC;
	}

	/**
	 * Sets the base of the Triangle
	 * 
	 * @param base the base
	 */
	public void setBase(double base) {

		this.base = base;
	}

	/**
	 * @return the base of the Triangle
	 */
	public double getBase() {
		return base;
	}

	/**
	 * Sets the height of the Triangle
	 * 
	 * @param height the height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the height of the Triangle
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @return the area of the Triangle
	 */
	public double getArea() {
		return ((base * height) / 2);
	}

	/**
	 * @return the perimeter of the Triangle
	 */
	public double getPerimeter() {
		return sideA + sideB + sideC;
	}

	/**
	 * @return true if the Triangle is an equilateral Triangle (all sides are the
	 *         same)
	 */
	public boolean isEquilateral() {
		return sideA == sideB && sideA == sideC;
	}

	@Override
	public String toString() {
		return "Triangle [sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + ", base=" +
				base + ", height=" + height + ", getArea()=" + getArea() + ", getPerimeter()=" +
				getPerimeter() + "]";
	}

}

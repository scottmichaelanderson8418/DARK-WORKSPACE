package com.CSC284;

public class Triangle implements Shape {
	private static double eps = 0.0001;
	private double sideA;
	private double sideB;
	private double sideC;
	private double base;
	private double height;

	public Triangle(double sideA, double sideB, double sideC) {

		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	/**
	 * Constructor that initializes fields of the Triangle to the values of the
	 * arguments it is passed
	 * 
	 * @param sideA  the length of side A
	 * @param sideB  the length of side B
	 * @param sideC  the length of side C
	 * @param length the base
	 * @param width  the height
	 */
	public Triangle(double sideA, double sideB, double sideC, double base, double height) {
		try {
			if (isValidTriangleSides(sideA, sideB, sideC)) {
				this.sideA = sideA;
				this.sideB = sideB;
				this.sideC = sideC;
			} else {
				throw new IllegalArgumentException(
						"Invalid values for the side values of the triangle");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (isValidTriangleBaseHeight(base, height)) {
			this.base = base;
			this.height = height;
		} else {
			throw new IllegalArgumentException(
					"Invalid values for the base and height of the triangle");
		}

	}

	/**
	 * no-arg constructor that initializes the length and width of the Triangle to 0
	 */
	public Triangle() {
		base = 0.0d;
		height = 0.0d;
		sideA = 0.0d;
		sideB = 0.0d;
		sideC = 0.0d;
	}

	public boolean isValidTriangleSides(double sideA, double sideB, double sideC) {

		if ((sideA + sideB) <= sideC) {
			return false;
		} else if ((sideA + sideC) <= sideB) {
			return false;
		} else if ((sideB + sideC) <= sideA) {
			return false;
		} else {

			return true;
		}

	}

	public boolean isValidTriangleBaseHeight(double base, double height) {

		double sideValue = Math.sqrt((.5 * base) * (.5 * base) + (height * height));

		System.out.println("sideValue= " + Math.round(sideValue));
		System.out.println(sideA);
		System.out.println(sideB);
		System.out.println(sideC);
		if (Math.abs(sideValue - this.sideA) < eps ? true : false) {
			return true;
		}
		if (Math.abs(sideValue - this.sideB) < eps ? true : false) {
			return true;
		}
		if (Math.abs(sideValue - this.sideC) < eps ? true : false) {
			return true;
		}

		return false;
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

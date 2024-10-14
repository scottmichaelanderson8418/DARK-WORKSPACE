package com.polymorphism;

public class Main {

	public static void main(String[] args) {

		(new TextBox()).enable();

		// Polymorphism - an object can take on many different forms
		drawUIControl(new TextBox());

		drawUIControl(new CheckBox());
	}

	public static void drawUIControl(UIControl control) {
		control.draw();

	}

}

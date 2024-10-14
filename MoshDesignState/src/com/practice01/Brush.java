package com.practice01;

public class Brush implements ToolControl {

	@Override
	public void mouseUp() {
		// TODO Auto-generated method stub

		System.out.println("Brush icon");
	}

	@Override
	public void mouseDown() {
		// TODO Auto-generated method stub
		System.out.println("Draw a line");
	}

}

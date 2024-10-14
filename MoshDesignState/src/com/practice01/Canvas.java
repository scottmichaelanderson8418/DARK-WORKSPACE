package com.practice01;

public class Canvas {

	private ToolControl currentTool;

	public void mouseDown() {
		currentTool.mouseDown();
	}

	public Canvas(ToolControl currentTool) {
		super();
		this.currentTool = currentTool;
	}

	public void mouseUp() {
		currentTool.mouseUp();

	}

	public ToolControl getCurrentTool() {
		return currentTool;
	}

	public void setCurrentTool(ToolControl currentTool) {
		this.currentTool = currentTool;
	}
}

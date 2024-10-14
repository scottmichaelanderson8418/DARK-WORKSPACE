package com.practice01scottdesign;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Editor editor = new Editor();

		editor.setContent("a");
		editor.setContent("b");
		editor.setContent("c");

		editor.undo();

		// System.out.println();

		System.out.println(editor.getContent());

		editor.undo();

		// System.out.println();

		System.out.println(editor.getContent());

		editor.undo();
		editor.undo();
		// System.out.println();

		System.out.println(editor.getContent());
		editor.setContent("a");
		editor.setContent("b");
		editor.setContent("c");

	}

}

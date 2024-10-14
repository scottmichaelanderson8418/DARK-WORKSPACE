package com.momento;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Editor editor = new Editor();
		History history = new History();

		editor.setContent("a");
		history.push(editor.createState());

		editor.setContent("b");

		history.push(editor.createState());

		editor.setContent("c");

		// history.push(editor.createState());

		editor.restore(history.pop());

		System.out.println("editor.getContent()= " + editor.getContent());

		// editor.restore(history.pop());
		// editor.restore(history.pop());

		System.out.println("editor.getContent()= " + editor.getContent());

		System.out.println(editor.getContent());

	}

}

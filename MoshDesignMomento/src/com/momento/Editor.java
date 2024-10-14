package com.momento;

public class Editor {

	private String content;
	// private History history = new History();

	public EditorState createState() {

		// history.push(state);
		return new EditorState(content);

	}

	public void restore(EditorState state) {

		content = state.getContent();

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		// createState(content);
		this.content = content;
	}

}

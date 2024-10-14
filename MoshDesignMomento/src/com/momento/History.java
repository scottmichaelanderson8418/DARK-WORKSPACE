package com.momento;

import java.util.ArrayList;
import java.util.List;

public class History {

	private List<EditorState> states = new ArrayList<>();

	public void push(EditorState state) {

		states.add(state);
	}

	public EditorState pop() {

		int lastIndex = states.size() - 1;

		EditorState lastState = states.get(lastIndex);
		System.out.print("states.get(lastIndex)= ");
		System.out.println(lastState.toString());

		this.states.remove(lastState);

		return lastState;
	}

	public List<EditorState> getList() {
		return states;
	}

}

package com.practice01scottdesign;

import java.util.ArrayList;
import java.util.List;

public class Editor {

	private String content;
	private int count;
	private int countA;

	private static List<String> contentList = new ArrayList<String>();

	public void store(String content) {

		contentList.add(content);

	}

	public String getContent() {
		if (count < 0) {
			count = 0;
			return "no value";
		} else {
			// System.out.println("Getting content at location = " + count);
			return contentList.get(count);
		}
	}

	public void setContent(String content) {
		// System.out.println("Storing content at location = " + count);

		store(content);
		count++;
		this.content = content;
	}

	public void undo() {
		count--;

		if ((count) < 0) {
			// System.out.println("count = " + count);
		} else {

			if (countA == 0) {
				// System.out.println("count= " + count);
				count = count - 1;
				setCount(count);
				countA++;
			} else {

				// System.out.println("count= " + count);

				setCount(count);

			}

		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

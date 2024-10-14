package com.practiceScott;

public class MyUser {

	private String username;
	private String message;
	private String[] role;
	private int id;
	private static int count = 0;

	public MyUser() {
		this.username = "";
		this.message = "";
		this.role = null;
		this.id = count;
		count++;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		MyUser.count = count;
	}

}

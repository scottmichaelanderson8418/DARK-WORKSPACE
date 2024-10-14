package com.encapsulation;

public class Account {

	private float balance;
	private String firstName;
	private String lastName;

	public Account() {
		this.firstName = "";
		this.lastName = "";
		this.balance = 0.0f;

	}

	public Account(String firstName, String lastName, float balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}

	public void withDraw(float amount) {
		if (amount < 0)
			this.balance -= amount;

	}

	public void deposit(float amount) {
		if (amount > 0)
			this.balance += amount;
	}

	public float getBalance() {
		return this.balance;
	}

}

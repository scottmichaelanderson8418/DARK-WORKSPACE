package com.encapsulation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account account = new Account("Scott", "Anderson", 35.55f);

		account.deposit(100.56f);

		account.getBalance();
		System.out.println(account.getBalance());

	}

}

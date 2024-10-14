package com.abstraction;

public class MailService {

	public void sendEmail() {

		connect(1);
		authenticate();
		disconnect();

	}

	// abstraction - we can change the implementation detail without affecting other
	// classes in our application

	private void connect(int timeOut) {
		System.out.println("Connect");

	}

	private void disconnect() {
		System.out.println("Disconnect");
	}

	private void authenticate() {
		System.out.println("Authenticate");
	}

}

package com.servermanagement;

public class MailServer implements IServer {

	@Override
	public void Resolve() {
		// TODO Auto-generated method stub

		System.out.println("Performing some complex Mail Server Resolution Algorithm");
		System.out.println("Mail server has been fixed :)");
	}

	@Override
	public void notifyPerson() {
		// TODO Auto-generated method stub
		System.out.println("Notifying Sue, the stakeholder of the Mail Server...");
	}

}

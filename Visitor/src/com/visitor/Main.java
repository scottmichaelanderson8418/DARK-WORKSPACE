package com.visitor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// smartphone alert
		Alert smartphoneAlert = new SmartPhone();

		smartphoneAlert.alert(new AlertDisplayVisitor());

		// // TV alert
		// Alert tvAlert = new TV();
		// tvAlert.alert(new AlertDisplayVisitor());
		//
		// // Radio alert
		// Alert radioAlert = new Radio();
		// radioAlert.alert(new AlertDisplayVisitor());
	}

}

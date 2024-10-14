
package com.visitor;

public class AlertDisplayVisitor implements AlertVisitor {

	@Override
	public void visit(SmartPhone smartphone) {
		// TODO Auto-generated method stub

		System.out.println("SMART PHONE ALERT--> SMS: Weather conditions are rough in your area. Drive carefully.");

	}

	@Override
	public void visit(TV tv) {
		// TODO Auto-generated method stub
		System.out
				.println("Channel 3 says: Stay indoors. Weather conditions are rough in the area.");
	}

	@Override
	public void visit(Radio radio) {
		// TODO Auto-generated method stub
		System.out.println("WCME Radio says: stay indoors.");

	}

}

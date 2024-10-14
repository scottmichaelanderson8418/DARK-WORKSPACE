
package com.visitor;

public class SmartPhone implements Alert {

	@Override
	public void alert(AlertVisitor alertVisitor) {
		// TODO Auto-generated method stub

		alertVisitor.visit(this);
	}

}

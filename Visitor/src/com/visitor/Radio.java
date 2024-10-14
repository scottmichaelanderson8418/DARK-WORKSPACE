
package com.visitor;

public class Radio implements Alert {

	@Override
	public void alert(AlertVisitor alertVisitor) {
		// TODO Auto-generated method stub

		alertVisitor.visit(this);
	}

}

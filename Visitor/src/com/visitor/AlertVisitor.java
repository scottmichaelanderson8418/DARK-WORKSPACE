
package com.visitor;

public interface AlertVisitor {

	public void visit(SmartPhone smartphone);

	public void visit(TV tv);

	public void visit(Radio radio);

}




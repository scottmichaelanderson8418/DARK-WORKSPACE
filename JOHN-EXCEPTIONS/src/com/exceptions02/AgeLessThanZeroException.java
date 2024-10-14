package com.exceptions02;

public class AgeLessThanZeroException extends Exception {

	public AgeLessThanZeroException() {
		super("Age less than zero");

	}

	public AgeLessThanZeroException(String s) {
		super(s);
	}

	public AgeLessThanZeroException(Throwable cause) {

		// when this exception gets printed out the cause of the exception will also be
		// printed out
		super(cause);
	}

	public AgeLessThanZeroException(String message, Throwable cause) {

		super(message, cause);
	}

}

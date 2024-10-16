package com.pokemonreview.exceptions;

import java.util.Date;

public class ErrorObject {

	private String message;
	private Integer statusCode;
	private Date timestamp;

	public ErrorObject() {

	}

	public ErrorObject(Integer statusCode, String message, Date timestamp) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}

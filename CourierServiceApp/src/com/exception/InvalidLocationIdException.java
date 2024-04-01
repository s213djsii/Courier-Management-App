package com.exception;

public class InvalidLocationIdException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public InvalidLocationIdException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}

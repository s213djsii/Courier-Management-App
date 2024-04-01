package com.exception;

public class InvalidCourierIdException extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	private String message;
	public InvalidCourierIdException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}

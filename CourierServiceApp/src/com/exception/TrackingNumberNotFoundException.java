package com.exception;

public class TrackingNumberNotFoundException extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	private String message;
	public TrackingNumberNotFoundException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}

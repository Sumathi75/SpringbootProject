package com.jspiders.springbootproject.exception;

public class AdharNotFoundException extends RuntimeException{

	private String message;

	

	public AdharNotFoundException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
}
}
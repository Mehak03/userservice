package com.au.asx.user.exception;

public class CustomException extends RuntimeException {
	
	private final String errorMessage;
	
	public CustomException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}

}

package com.masai.exception;

public class PostAlreadyPresentException extends RuntimeException{



	public PostAlreadyPresentException() {
		
	}
	

	public PostAlreadyPresentException(String message) {
		super(message);
	}
}

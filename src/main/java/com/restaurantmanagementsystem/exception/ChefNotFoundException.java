package com.restaurantmanagementsystem.exception;

@SuppressWarnings("serial")
public class ChefNotFoundException extends RuntimeException {

	public ChefNotFoundException() {
		super();
	}

	public ChefNotFoundException(String message) {
		super(message);
	}

	public ChefNotFoundException(Throwable cause) {
		super(cause);
	}

	public ChefNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

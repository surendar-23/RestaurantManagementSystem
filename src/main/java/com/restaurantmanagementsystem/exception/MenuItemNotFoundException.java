package com.restaurantmanagementsystem.exception;

@SuppressWarnings("serial")
public class MenuItemNotFoundException extends RuntimeException {

	public MenuItemNotFoundException() {
		super();
	}

	public MenuItemNotFoundException(String message) {
		super(message);
	}

	public MenuItemNotFoundException(Throwable cause) {
		super(cause);
	}

	public MenuItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

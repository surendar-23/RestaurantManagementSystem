package com.restaurantmanagementsystem.exception;

@SuppressWarnings("serial")
public class WaiterNotFoundException extends RuntimeException {

	public WaiterNotFoundException() {
		super();
	}

	public WaiterNotFoundException(String message) {
		super(message);
	}

	public WaiterNotFoundException(Throwable cause) {
		super(cause);
	}

	public WaiterNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

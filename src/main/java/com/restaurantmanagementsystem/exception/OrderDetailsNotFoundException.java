package com.restaurantmanagementsystem.exception;

@SuppressWarnings("serial")
public class OrderDetailsNotFoundException extends RuntimeException {

	public OrderDetailsNotFoundException() {
		super();
	}

	public OrderDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OrderDetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderDetailsNotFoundException(String message) {
		super(message);
	}

	public OrderDetailsNotFoundException(Throwable cause) {
		super(cause);
	}
}

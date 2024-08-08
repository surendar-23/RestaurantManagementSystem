package com.restaurantmanagementsystem.exception;

@SuppressWarnings("serial")
public class RestaurantNotFoundException extends RuntimeException {

	public RestaurantNotFoundException() {
		super();
	}

	public RestaurantNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RestaurantNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestaurantNotFoundException(String message) {
		super(message);
	}

	public RestaurantNotFoundException(Throwable cause) {
		super(cause);
	}
}

package com.restaurantmanagementsystem.exception;

@SuppressWarnings("serial")
public class TableNotFoundException extends RuntimeException {

	public TableNotFoundException() {
		super();
	}

	public TableNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TableNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TableNotFoundException(String message) {
		super(message);
	}

	public TableNotFoundException(Throwable cause) {
		super(cause);
	}
}

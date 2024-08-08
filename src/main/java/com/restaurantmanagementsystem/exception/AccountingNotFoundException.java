package com.restaurantmanagementsystem.exception;

@SuppressWarnings("serial")
public class AccountingNotFoundException extends RuntimeException {

	public AccountingNotFoundException() {
		super();
	}

	public AccountingNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccountingNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountingNotFoundException(String message) {
		super(message);
	}

	public AccountingNotFoundException(Throwable cause) {
		super(cause);
	}
}

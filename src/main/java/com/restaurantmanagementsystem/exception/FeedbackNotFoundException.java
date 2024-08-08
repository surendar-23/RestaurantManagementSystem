package com.restaurantmanagementsystem.exception;

@SuppressWarnings("serial")
public class FeedbackNotFoundException extends RuntimeException {

	public FeedbackNotFoundException() {
		super();
	}

	public FeedbackNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FeedbackNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FeedbackNotFoundException(String message) {
		super(message);
	}

	public FeedbackNotFoundException(Throwable cause) {
		super(cause);
	}
}

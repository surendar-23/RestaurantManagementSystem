package com.restaurantmanagementsystem.exception;

@SuppressWarnings("serial")
public class InventoryItemNotFoundException extends RuntimeException {

	public InventoryItemNotFoundException() {
		super();
	}

	public InventoryItemNotFoundException(String message) {
		super(message);
	}

	public InventoryItemNotFoundException(Throwable cause) {
		super(cause);
	}

	public InventoryItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

package com.restaurantmanagementsystem.exception;

public class OrderDetailsErrorResponse {
	private int status;
	private String message;
	private long timeStamp;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public OrderDetailsErrorResponse() {
		super();
	}

	public OrderDetailsErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "OrderDetailsErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp
				+ "]";
	}
}

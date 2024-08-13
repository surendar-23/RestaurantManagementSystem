package com.example.restaurantmanagementsystem.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
		Map<String, String> errorDetails = new HashMap<>();
		errorDetails.put("error", ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	protected ResponseEntity<Map<String, String>> handleConstraintViolationException(
			SQLIntegrityConstraintViolationException ex, WebRequest request) {
		Map<String, String> errorDetails = new HashMap<>();
		errorDetails.put("error", "Oops, duplicate entry of the data!");
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	// You might also want to handle generic exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
		Map<String, String> errorDetails = new HashMap<>();
		errorDetails.put("error", "An unexpected error occurred: " + ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

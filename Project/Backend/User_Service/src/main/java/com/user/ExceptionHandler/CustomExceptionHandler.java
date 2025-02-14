package com.user.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import com.user.dto.Error;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(value = HandlerMethodValidationException.class)
	public ResponseEntity<Error> existVerification(HandlerMethodValidationException e) {
		Error error = new Error();
		
		error.setType("Validation Error");
		error.setMessage(e.getMessage());
		error.setTime(LocalDateTime.now());
		error.setAbstractMessage("Input is Invalid");
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Error> createVerification(MethodArgumentNotValidException e) {
		Error error = new Error();
		
		error.setType("Validation Error");
		error.setMessage(e.getMessage());
		error.setTime(LocalDateTime.now());
		error.setAbstractMessage("Input is Invalid");
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}
}

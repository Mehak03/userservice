package com.au.asx.user.exception;

import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * ExceptionAdvice to handle different types of exception and return appropriate http status code
 *
 */
@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<Object> handleMethodArgumentNotValid(final HttpServletRequest request, final MethodArgumentNotValidException e){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseBody
	public ResponseEntity<Object> handleMethodArgumentNotValid(final HttpServletRequest request, final MethodArgumentTypeMismatchException e){
		String errorMessage = "Invalid Method argument " + e.getValue();
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TimeoutException.class)
	@ResponseBody
	public ResponseEntity<Object> handleTimeOut(final HttpServletRequest request, final TimeoutException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.GATEWAY_TIMEOUT);
	}
	
	@ExceptionHandler(CustomException.class)
	@ResponseBody
	public ResponseEntity<Object> handleTechException(final HttpServletRequest request, final CustomException e){
		return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handleUnknownException(final HttpServletRequest request, final Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

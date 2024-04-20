package com.kairos.ecommerce.price.adapter.in.rest.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.kairos.ecommerce.price.adapter.in.rest.controller.exception.model.RestError;
import com.kairos.ecommerce.price.exception.ProductoNotFoundException;

@ControllerAdvice
public class RestResponseExceptionHandler { 

	private static final String ERROR_INTERNO = "Error";
	
	@ExceptionHandler(NoHandlerFoundException.class)
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex) {
		return new ResponseEntity<>(new  RestError(ERROR_INTERNO, HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.value(), ex.getMessage()),
				new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductoNotFoundException.class)
	protected ResponseEntity<Object> handleProductNotFound(ProductoNotFoundException ex) {
		return new ResponseEntity<>(new  RestError(ERROR_INTERNO, HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.value(), ex.getMessage()),
				new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleRuntimeError(Exception ex) {	
		return new ResponseEntity<>(new  RestError(ERROR_INTERNO, HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.value(), ex.getMessage()),
				new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}

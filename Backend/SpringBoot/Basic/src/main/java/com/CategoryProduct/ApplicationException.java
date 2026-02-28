package com.CategoryProduct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ApplicationException {
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<String> handleException(CategoryNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}

package com.jspiders.springbootproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jspiders.springbootproject.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleUserNotFoundException(UserNotFound exception){
		
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(exception.getMessage());
		structure.setMessage("could not find user with the provided id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ResponseStructure<String>> handleAdharNotFoundException(AdharNotFoundException adharexception){
		
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(adharexception.getMessage());
		structure.setMessage("could not find adhar with the provided id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
}

package com.foodApp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException ce,WebRequest web){
		
		MyErrorDetails errorDetails=new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ce.getMessage());
		errorDetails.setDetail(web.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException le,WebRequest web){
		
		MyErrorDetails errorDetails=new MyErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(le.getMessage());
		errorDetails.setDetail(web.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<MyErrorDetails> restaurantExceptionHandler(RestaurantException re,WebRequest web){
		
		MyErrorDetails errorDetails=new MyErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(re.getMessage());
		errorDetails.setDetail(web.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<MyErrorDetails> itemExceptionHandler(ItemException ie,WebRequest web){
		
		MyErrorDetails errorDetails=new MyErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ie.getMessage());
		errorDetails.setDetail(web.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> categoryExceptionHandler(CategoryException ce,WebRequest web){
		
		MyErrorDetails errorDetails=new MyErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ce.getMessage());
		errorDetails.setDetail(web.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception e,WebRequest web){
		
		MyErrorDetails errorDetails=new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(e.getMessage());
		errorDetails.setDetail(web.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}

}

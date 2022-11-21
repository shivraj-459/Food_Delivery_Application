package com.foodApp.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyErrorDetails {
	
	
	private LocalDateTime timeStamp;
	private String message;
	private String detail;
	
	

}

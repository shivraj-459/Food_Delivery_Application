package com.foodApp.model;

import lombok.Data;

@Data
public class CustomerDTO {
	
	private String firstName;
	private String lastName;
	private String mobileNumber;
	
	
	
	
	public CustomerDTO(String firstName, String lastName, String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}




	public CustomerDTO() {
		super();
	}
	
	
	

}

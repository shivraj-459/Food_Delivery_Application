package com.foodApp.model;

import lombok.Data;

@Data
public class RestaurantDTO {

	private String restaurantName;
    private String managerName;
	private String contactNumber;
	
	
	public RestaurantDTO() {
		// TODO Auto-generated constructor stub
	}


	public RestaurantDTO(String restaurantName, String managerName, String contactNumber) {
		super();
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}
	
	
	
	
}

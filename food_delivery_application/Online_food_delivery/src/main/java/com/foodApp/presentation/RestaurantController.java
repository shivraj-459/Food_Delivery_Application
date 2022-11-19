package com.foodApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.exception.RestaurantException;
import com.foodApp.model.Restaurant;
import com.foodApp.model.RestaurantDTO;
import com.foodApp.service.RestaurantService;



@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/restaurants")
	public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody Restaurant restaurant) throws RestaurantException{
		
		RestaurantDTO restaurantDTO=restaurantService.addRestaurant(restaurant);
		
		return new ResponseEntity<RestaurantDTO>(restaurantDTO, HttpStatus.OK);
		
	}

}

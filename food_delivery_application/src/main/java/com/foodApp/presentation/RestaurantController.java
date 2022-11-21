package com.foodApp.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.exception.ItemException;
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
	
	
	@PutMapping("/restaurants")
	public ResponseEntity<RestaurantDTO> updateRestaurant(@RequestBody Restaurant restaurant) throws RestaurantException{
		
		RestaurantDTO restaurantDTO=restaurantService.updateRestaurant(restaurant);
		
		
		return new ResponseEntity<RestaurantDTO>(restaurantDTO,HttpStatus.OK);
		
	}
	
	@DeleteMapping("restaurants/{restaurantId}")
	public ResponseEntity<RestaurantDTO> removeRestaurant(@PathVariable("restaurantId") Integer restaurantId) throws RestaurantException{
		
		RestaurantDTO restaurantDTO=restaurantService.removeRestaurant(restaurantId);
		
		
		return new ResponseEntity<RestaurantDTO>(restaurantDTO,HttpStatus.OK);
		
	}
	
	@GetMapping("restaurants/{restaurantName}")
	public ResponseEntity<RestaurantDTO> viewRestaurantByName(@PathVariable("restaurantName") String restaurantName) throws RestaurantException{
		
		RestaurantDTO restaurantDTO=restaurantService.viewRestaurantByName(restaurantName);
		
		
		return new ResponseEntity<RestaurantDTO>(restaurantDTO,HttpStatus.OK);
	}
	
	
	@GetMapping("/restaurantsbyitem/{itemName}")
	public ResponseEntity<List<RestaurantDTO>> getListOfRestaurantsByItemName(@PathVariable("itemName") String itemName) throws RestaurantException, ItemException{
		
		
		List<RestaurantDTO> list=restaurantService.viewRestaurantByItemName(itemName);
		
		
		return new ResponseEntity<List<RestaurantDTO>>(list, HttpStatus.OK);
	}

}

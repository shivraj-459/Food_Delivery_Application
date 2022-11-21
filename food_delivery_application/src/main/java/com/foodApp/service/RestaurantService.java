package com.foodApp.service;

import java.util.List;

import com.foodApp.exception.ItemException;
import com.foodApp.exception.RestaurantException;
import com.foodApp.model.Restaurant;
import com.foodApp.model.RestaurantDTO;

public interface RestaurantService {
	
	public RestaurantDTO addRestaurant(Restaurant restaurant) throws RestaurantException;
	
	public RestaurantDTO updateRestaurant(Restaurant restaurant) throws RestaurantException;
	
	public RestaurantDTO removeRestaurant(Integer restaurantId) throws RestaurantException;
	
	public RestaurantDTO viewRestaurantByName(String restaurantName) throws RestaurantException;
	
	public List<RestaurantDTO> viewRestaurantByItemName(String itemName) throws RestaurantException,ItemException;
	
	

}

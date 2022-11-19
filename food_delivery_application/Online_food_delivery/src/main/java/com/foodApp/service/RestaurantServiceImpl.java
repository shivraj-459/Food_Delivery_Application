package com.foodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.exception.RestaurantException;
import com.foodApp.model.Restaurant;
import com.foodApp.model.RestaurantDTO;
import com.foodApp.repository.RestaurantDao;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantDao restaurantDao;
	
	@Override
	public RestaurantDTO addRestaurant(Restaurant restaurant) throws RestaurantException {
		
		restaurant.setRestaurantName(restaurant.getRestaurantName().toLowerCase());
		
		Optional<Restaurant> optional=restaurantDao.findByRestaurantName(restaurant.getRestaurantName());
		
		if(optional.isPresent()) {
			throw new RestaurantException("Restaurant is already Registered with this name");
		}
		
		Restaurant addedRestaurant= restaurantDao.save(restaurant);
		
		RestaurantDTO restaurantDTO=new RestaurantDTO();
		restaurantDTO.setRestaurantName(addedRestaurant.getRestaurantName());
		restaurantDTO.setManagerName(addedRestaurant.getManagerName());
		restaurantDTO.setContactNumber(addedRestaurant.getContactNumber());
		
		
		
		return restaurantDTO;
	}

	@Override
	public RestaurantDTO updateRestaurant(Restaurant restaurant) throws RestaurantException {

       Optional<Restaurant> optional=restaurantDao.findByRestaurantName(restaurant.getRestaurantName());
		
		if(optional.isPresent()) {
                 
			Restaurant updatedRestaurant=restaurantDao.save(restaurant);
			
			RestaurantDTO restaurantDTO=new RestaurantDTO();
			restaurantDTO.setRestaurantName(updatedRestaurant.getRestaurantName());
			restaurantDTO.setManagerName(updatedRestaurant.getManagerName());
			restaurantDTO.setContactNumber(updatedRestaurant.getContactNumber());
			
			return restaurantDTO;
		}
		else {
			throw new RestaurantException("No Restaurant is registred with this name");
		}
		
	}

	@Override
	public RestaurantDTO removeRestaurant(Restaurant restaurant) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDTO viewRestaurantByName(String restaurantName) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDTO> viewRestaurantByItemName(String itemName) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

}

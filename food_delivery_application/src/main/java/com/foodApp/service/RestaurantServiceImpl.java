package com.foodApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.exception.ItemException;
import com.foodApp.exception.RestaurantException;
import com.foodApp.model.Item;
import com.foodApp.model.Restaurant;
import com.foodApp.model.RestaurantDTO;
import com.foodApp.repository.ItemsDao;
import com.foodApp.repository.RestaurantDao;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private ItemsDao itemDao;
	
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
	public RestaurantDTO removeRestaurant(Integer restaurantId) throws RestaurantException {

         Optional<Restaurant> optional=restaurantDao.findById(restaurantId);
         
         if(!optional.isPresent()) {
        	 
        	 throw new RestaurantException("Restaurant does not exist with this id");
         }
         
         Restaurant restaurant=optional.get();
         
         RestaurantDTO restaurantDTO=new RestaurantDTO(restaurant.getRestaurantName(),restaurant.getManagerName(),restaurant.getContactNumber());
		
		return restaurantDTO;
	}

	@Override
	public RestaurantDTO viewRestaurantByName(String restaurantName) throws RestaurantException {

              Optional<Restaurant> optional=restaurantDao.findByRestaurantName(restaurantName);
              
              
              if(!optional.isPresent()) {
            	  
            	  throw new RestaurantException("No restaurant is Registered with this name");
              }
		
              Restaurant restaurant=optional.get();
              
              
              RestaurantDTO restaurantDTO=new RestaurantDTO(restaurant.getRestaurantName(),restaurant.getManagerName(),restaurant.getContactNumber());
      		
      		return restaurantDTO;   
              
	}

	@Override
	public List<RestaurantDTO> viewRestaurantByItemName(String itemName) throws RestaurantException,ItemException{

          Optional<Item> optional=  itemDao.findByItemName(itemName);
          
          if(!optional.isPresent()) {
        	  
        	  throw new ItemException("item does not present in database");
          }
          
          Item item=optional.get();
          
         Set<Restaurant> restaurants= item.getRestaurants();
         
         List<RestaurantDTO> list=new ArrayList<>();
         
         for(Restaurant r:restaurants) {
        	 
        	 RestaurantDTO restaurantDTO=new RestaurantDTO(r.getRestaurantName(),r.getManagerName(),r.getContactNumber());
        	 
        	 list.add(restaurantDTO);
         }
		
		if(list.size()==0) {
			throw new RestaurantException("No restaurant found");
		}
		
		return list;
	}

}

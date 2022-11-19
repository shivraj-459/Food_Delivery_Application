package com.foodApp.service;

import java.util.List;

import com.foodApp.exception.CategoryException;
import com.foodApp.exception.ItemException;
import com.foodApp.exception.RestaurantException;
import com.foodApp.model.Item;
import com.foodApp.model.ItemDTO;


public interface ItemsService {
	
	 public ItemDTO addItem(Item item,Integer categoryId) throws ItemException,CategoryException;
	 
	 public ItemDTO updateItem(Item item) throws ItemException;
	 
	 public ItemDTO viewItemByName(String itemName) throws ItemException;
	 
	 public ItemDTO removeItemByItemName(String itemName)throws ItemException;
	 
	 public List<ItemDTO> viewItemsByCategoryName(String categoryName) throws ItemException;
	 
	 public List<ItemDTO> viewItemsByRestaurantName(String restaurantName) throws ItemException,RestaurantException;
	 
	 public ItemDTO addItemToRestaurant(String itemName,String restaurantName) throws ItemException,RestaurantException;

}

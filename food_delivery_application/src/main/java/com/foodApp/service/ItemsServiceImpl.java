package com.foodApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.exception.CategoryException;
import com.foodApp.exception.ItemException;
import com.foodApp.exception.RestaurantException;
import com.foodApp.model.Category;
import com.foodApp.model.Item;
import com.foodApp.model.ItemDTO;
import com.foodApp.model.Restaurant;
import com.foodApp.repository.CategoryDao;
import com.foodApp.repository.ItemsDao;
import com.foodApp.repository.RestaurantDao;

@Service
public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsDao itemsDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public ItemDTO addItem(Item item,Integer categoryId) throws ItemException,CategoryException {

		Optional<Category> optionalcategory= categoryDao.findById(categoryId);
		
		if(!optionalcategory.isPresent()) {
			
			throw new CategoryException("category does not exist");
		}
		
		Category category=optionalcategory.get();
		
		item.setItemName(item.getItemName().toLowerCase());
        Optional<Item> optional=itemsDao.findByItemName(item.getItemName());
        
        
        if(optional.isPresent()) {
        	throw new ItemException("Item already registered");
        }
        
        item.setCategory(category);
            
        Item addedItem=itemsDao.save(item);
		
        ItemDTO itemDTO=new ItemDTO(addedItem.getItemName(),addedItem.getQuantity(),addedItem.getCostPerItem());
		
		return itemDTO;
	}

	@Override
	public ItemDTO updateItem(Item item) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDTO viewItemByName(String itemName) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDTO removeItemByItemName(String itemName) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> viewItemsByCategoryName(String categoryName) throws ItemException {

		  
         Optional<Category> optional= categoryDao.findByCategoryName(categoryName);
		
         if(!optional.isPresent()) {
        	 
        	 throw new ItemException("category is not present");
         }
         
         Category newCategory=optional.get();
         
        List<Item> list= itemsDao.findByCategory(newCategory);
        
        if(list.isEmpty()) {
        	
        	throw new ItemException("item not exist for this category");
        }
        
        List<ItemDTO> list2=new ArrayList<>();
        
        for(Item i: list) {
        	
        	ItemDTO itemDTO=new ItemDTO(i.getItemName(), i.getQuantity(), i.getCostPerItem());
        	list2.add(itemDTO);
        }
         
		return list2;
	}

	@Override
	public List<ItemDTO> viewItemsByRestaurantName(String restaurantName) throws ItemException,RestaurantException {

           Optional<Restaurant> optional=restaurantDao.findByRestaurantName(restaurantName);
           
           if(!optional.isPresent()) {
        	   
        	   throw new RestaurantException("Restaurant is not registered with this name");
           }
           
           Restaurant restaurant=optional.get();
           
           Set<Item> set=restaurant.getItems();
           
           if(set.isEmpty()) {
        	   throw new ItemException("No Item found");
           }
           
           List<ItemDTO> list=new ArrayList<>();
           
           for(Item i: set) {
        	   
        	   ItemDTO itemDTO=new ItemDTO(i.getItemName(),i.getQuantity(),i.getCostPerItem());
        	   list.add(itemDTO);
           }
           
           
		
		return list;
	}

	@Override
	public ItemDTO addItemToRestaurant(String itemName,String restaurantName) throws ItemException, RestaurantException {

           Optional<Item> optional=itemsDao.findByItemName(itemName.toLowerCase());
           
           if(!optional.isPresent()) {
        	   
        	   throw new ItemException("item not registered");
           }
           
           Item newItem=optional.get();
           
           Optional<Restaurant> optional2=restaurantDao.findByRestaurantName(restaurantName.toLowerCase());
           
           if(!optional2.isPresent()) {
        	   
        	   throw new RestaurantException("Restaurant not exist");
           }
           
         Restaurant newRestaurant= optional2.get();
         
         newRestaurant.getItems().add(newItem);
         
         restaurantDao.save(newRestaurant);
         
         newItem.getRestaurants().add(newRestaurant);
         Item item2= itemsDao.save(newItem);
         
         ItemDTO itemDTO=new ItemDTO(item2.getItemName(), item2.getQuantity(),item2.getCostPerItem());
		
		return itemDTO;
	}

}

package com.foodApp.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.exception.CategoryException;
import com.foodApp.exception.ItemException;
import com.foodApp.exception.RestaurantException;
import com.foodApp.model.Item;
import com.foodApp.model.ItemDTO;
import com.foodApp.service.ItemsService;

@RestController
public class ItemController {

	@Autowired
	private ItemsService itemsService;
	
	@PostMapping("/items/{categoryId}")
	public ResponseEntity<ItemDTO> addItem(@RequestBody Item item,@PathVariable Integer categoryId) throws ItemException, CategoryException{
		
		ItemDTO itemDTO=itemsService.addItem(item,categoryId);
		
		return new ResponseEntity<ItemDTO>(itemDTO,HttpStatus.OK);
	}
	
	@PatchMapping("/items/{itemName}/{restaurantName}")
	public ResponseEntity<ItemDTO> addItemToRestaurant(@RequestParam("itemName") String itemName,@RequestParam String restaurantName) throws ItemException, RestaurantException{
	
		ItemDTO itemDTO=itemsService.addItemToRestaurant(itemName, restaurantName);
		
		return new ResponseEntity<ItemDTO>(itemDTO,HttpStatus.OK);
	}
	
	@GetMapping("/items/{restaurantName}")
	public ResponseEntity<List<ItemDTO>> getListOfItemsFromRestaurant(@RequestParam("restaurantName") String restaurantName) throws ItemException, RestaurantException{
		
		List<ItemDTO> list=itemsService.viewItemsByRestaurantName(restaurantName);
		
		return new ResponseEntity<List<ItemDTO>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/itemsbycategory/{categoryName}")
	public ResponseEntity<List<ItemDTO>> getListOfItemByCategory(@RequestParam("categoryName") String category) throws ItemException{
		
		List<ItemDTO> list=itemsService.viewItemsByCategoryName(category);
		
		return new ResponseEntity<List<ItemDTO>>(list,HttpStatus.OK);
	}
	
}

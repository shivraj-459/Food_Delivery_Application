package com.foodApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.exception.CategoryException;
import com.foodApp.model.Category;
import com.foodApp.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/categories")
	public ResponseEntity<Category> addCategoryHandler(@RequestBody Category category) throws CategoryException{
		
		
		Category addedcategory=categoryService.addCategory(category);
		
		return new ResponseEntity<Category>(addedcategory, HttpStatus.OK);
	}
	
	
	@PatchMapping("/categories/{categoryName}/{categoryId}")
	public ResponseEntity<String> updateCategoryHandler(@RequestParam("categoryName") String categoryName,@PathVariable("categoryId") Integer categoryId) throws CategoryException{
		
		
		String updatedcategory=categoryService.updateCategoryName(categoryName,categoryId);
		
		return new ResponseEntity<String>(updatedcategory, HttpStatus.OK);
	}
}

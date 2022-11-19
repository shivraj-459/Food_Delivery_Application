package com.foodApp.service;

import com.foodApp.exception.CategoryException;
import com.foodApp.model.Category;

public interface CategoryService {
	
	public Category addCategory(Category category) throws CategoryException;
	
	public String updateCategoryName(String categoryName,Integer categoryId) throws CategoryException;

}

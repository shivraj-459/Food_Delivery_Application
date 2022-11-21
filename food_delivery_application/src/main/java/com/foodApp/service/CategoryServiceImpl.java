package com.foodApp.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.exception.CategoryException;
import com.foodApp.model.Category;
import com.foodApp.repository.CategoryDao;
import com.foodApp.repository.ItemsDao;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ItemsDao itemsDao;
	
	@Override
	public Category addCategory(Category category) throws CategoryException {

		category.setCategoryName(category.getCategoryName().toUpperCase());
        Optional<Category> existOptional=  categoryDao.findByCategoryName(category.getCategoryName());
        
        if(existOptional.isPresent()) {
        	
        	throw new CategoryException("category already Exist"); 
        }
        
      return categoryDao.save(category);
		
	}

	@Override
	public String updateCategoryName(String categoryName,Integer categoryId) throws CategoryException {

		 
		 Optional<Category> existOptional=  categoryDao.findById(categoryId);
		
		 if(!existOptional.isPresent()) {
	        	
	        	throw new CategoryException("category does not Exist"); 
	        }
		 
		 Category category=existOptional.get();
		 
		  category.setCategoryName(categoryName.toUpperCase());
		  
		 
		 categoryDao.save(category);
		 
		 
		 
		
		return "category Name successfully updated";
	}

}

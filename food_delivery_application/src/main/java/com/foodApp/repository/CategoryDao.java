package com.foodApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodApp.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{
	
	@Query("select c from Category c where c.categoryName=?1")
	public Optional<Category> findByCategoryName(String categoryName);

}

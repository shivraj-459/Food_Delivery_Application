package com.foodApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodApp.model.Category;
import com.foodApp.model.Item;

@Repository
public interface ItemsDao extends JpaRepository<Item, Integer>{

	@Query("select i from Item i where i.itemName=?1")
	public Optional<Item> findByItemName(String itemName);
	
	public List<Item> findByCategory(Category category);
	
}

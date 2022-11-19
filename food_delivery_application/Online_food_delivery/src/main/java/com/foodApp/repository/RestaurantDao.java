package com.foodApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodApp.model.Restaurant;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {

	public Optional<Restaurant> findByRestaurantName(String restaurantName);
	
}

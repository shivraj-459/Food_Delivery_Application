package com.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodApp.model.LoginData;

@Repository
public interface LoginDataDao extends JpaRepository<LoginData,Integer> {
	
	
	public LoginData findByUserId(Integer userId);

}

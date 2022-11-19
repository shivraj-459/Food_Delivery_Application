package com.foodApp.service;

import com.foodApp.exception.LoginException;
import com.foodApp.model.LoginData;

public interface LoginDataService {
	
	
	public String customerLogin(LoginData loginData) throws LoginException;
	
	public String customerLogout(String uuid)throws LoginException;

}

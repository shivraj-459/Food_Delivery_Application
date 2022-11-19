package com.foodApp.service;

import com.foodApp.exception.LoginException;
import com.foodApp.model.CurrentUserSession;
import com.foodApp.model.Customer;

public interface CurrentUserSessionService {
	
	public CurrentUserSession getCurrentUserSession(String uuid) throws LoginException;
	
	public Integer getCurrentUserSessionId(String uuid) throws LoginException;
	
	public Customer getCustomerDetails(String uuid);

}

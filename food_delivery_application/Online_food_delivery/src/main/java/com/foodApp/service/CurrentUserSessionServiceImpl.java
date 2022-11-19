package com.foodApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.exception.LoginException;
import com.foodApp.model.CurrentUserSession;
import com.foodApp.model.Customer;
import com.foodApp.repository.CurrentUserSessionDao;
import com.foodApp.repository.CustomerDao;

@Service
public class CurrentUserSessionServiceImpl implements CurrentUserSessionService{

	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public CurrentUserSession getCurrentUserSession(String uuid) throws LoginException {
		
		Optional<CurrentUserSession> optional=currentUserSessionDao.findByUuid(uuid);
		
		if(!optional.isPresent()) {
			
			throw new LoginException("UnAuthorized");
		}
		
		return optional.get();
	}

	@Override
	public Integer getCurrentUserSessionId(String uuid) throws LoginException {


    Optional<CurrentUserSession> optional=currentUserSessionDao.findByUuid(uuid);
		
		if(!optional.isPresent()) {
			
			throw new LoginException("UnAuthorized");
		}
		
		return optional.get().getSessionId();
	}

	@Override
	public Customer getCustomerDetails(String uuid) {


		Optional<CurrentUserSession> optional=currentUserSessionDao.findByUuid(uuid);
		
		if(optional.isPresent()) {
			
			Integer customerId=optional.get().getUserId();
			
			return customerDao.findById(customerId).get();
		}
		
		return null;
	}

}

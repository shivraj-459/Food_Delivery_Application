package com.foodApp.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.exception.LoginException;
import com.foodApp.model.CurrentUserSession;
import com.foodApp.model.Customer;
import com.foodApp.model.LoginData;
import com.foodApp.repository.CurrentUserSessionDao;
import com.foodApp.repository.CustomerDao;
import com.foodApp.repository.LoginDataDao;

@Service
public class LoginDataServiceImpl implements LoginDataService{

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private LoginDataDao loginDataDao;
	
	@Override
	public String customerLogin(LoginData loginData) throws LoginException {

       Optional<Customer> optional=customerDao.findByEmail(loginData.getUserName());
       
       if(!optional.isPresent()) {
    	   
    	   throw new LoginException("Invalid Login UserId");
       }
       
       Customer newCustomer=optional.get();
       
       Optional<CurrentUserSession> optionalSession=  currentUserSessionDao.findByUserId(newCustomer.getCustomerId());
       
       if(optionalSession.isPresent()) {
    	   
    	   throw new LoginException("User Already with this userId");
       }
       
       if(newCustomer.getEmail().equals(loginData.getUserName()) && newCustomer.getPassword().equals(loginData.getPassword())) {
    	   
    	   String uuidString=RandomString.getRandomNumberString();
    	   
    	   CurrentUserSession session=new CurrentUserSession(newCustomer.getCustomerId(), uuidString, LocalDateTime.now());
    	   currentUserSessionDao.save(session);
    	   
    	   LoginData newLoginData=new LoginData();
    	   newLoginData.setUserId(session.getSessionId());
    	   newLoginData.setUserName(loginData.getUserName());
    	   newLoginData.setPassword(loginData.getPassword());
    	   
    	   loginDataDao.save(newLoginData);
    	   
    	   
    	   return session.toString();
       }
       
       else {
    	   throw new LoginException("Invalid UserName or Password!");
       }
		
	}

	@Override
	public String customerLogout(String uuid) throws LoginException {
		
      Optional<CurrentUserSession> currentUserOptional= currentUserSessionDao.findByUuid(uuid);
		
		if(!currentUserOptional.isPresent())
		{
			throw new LoginException("User has not logged in with this UserId");
		}
		
		CurrentUserSession currentUserSession =currentUserOptional.get();
		
		currentUserSessionDao.delete(currentUserSession);
		
		LoginData logindata = loginDataDao.findByUserId(currentUserSession.getSessionId());

        loginDataDao.delete(logindata);
		
        return "Logged Out......";
	}

}

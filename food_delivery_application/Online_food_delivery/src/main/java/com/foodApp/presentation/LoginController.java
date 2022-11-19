package com.foodApp.presentation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.exception.LoginException;
import com.foodApp.model.LoginData;
import com.foodApp.service.LoginDataService;




@RestController
public class LoginController {
    @Autowired
	private LoginDataService loginservice;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginData logindata) throws LoginException{
		
		String loginMessage = loginservice.customerLogin(logindata);
		
		return new ResponseEntity<>(loginMessage, HttpStatus.OK);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logout(@RequestParam("uuid") String uuid) throws LoginException{
		
		System.out.println(uuid);
		
		String logoutMessage = loginservice.customerLogout(uuid);
		
		
		return new ResponseEntity<>(logoutMessage, HttpStatus.OK);
	}
	
}

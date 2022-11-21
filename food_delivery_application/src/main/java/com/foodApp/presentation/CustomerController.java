package com.foodApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.exception.CustomerException;
import com.foodApp.model.Customer;
import com.foodApp.model.CustomerDTO;
import com.foodApp.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<CustomerDTO> addCustomer(@RequestBody Customer customer) throws CustomerException {
		
		CustomerDTO customerDTO=customerService.addCustomer(customer);
		
		return new ResponseEntity<CustomerDTO>(customerDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer) throws CustomerException{
		
		CustomerDTO updatedCustomer = customerService.updateCustomer(customer);
		
		
		return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);
	}
    
    
    @DeleteMapping("/deletecustomer/{email}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("email") String email) throws CustomerException{
		
		CustomerDTO deletedCustomer = customerService.removeCustomer(email);
		
		
		return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
	}
	
    
    @GetMapping("/viewcustomer/{email}")
    public ResponseEntity<CustomerDTO> viewCustomer(@PathVariable("email") String email) throws CustomerException{
		
		CustomerDTO viewedCustomer = customerService.viewCustomer(email);
		
		
		return new ResponseEntity<>(viewedCustomer, HttpStatus.OK);
	}
	
}

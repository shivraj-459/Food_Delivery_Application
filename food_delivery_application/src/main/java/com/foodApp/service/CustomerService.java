package com.foodApp.service;

import com.foodApp.exception.CustomerException;
import com.foodApp.model.Customer;
import com.foodApp.model.CustomerDTO;

public interface CustomerService {

	public CustomerDTO addCustomer(Customer customer) throws CustomerException;
	
	public CustomerDTO updateCustomer(Customer customer) throws CustomerException;
	
	public CustomerDTO removeCustomer(String email) throws CustomerException;
	
    public CustomerDTO viewCustomer(String email) throws CustomerException;
	
	//public List<CustomerDTO> viewAllCustomer() throws CustomerException;
}

package com.service;

import java.util.List;

import com.model.Customer;

public interface CustomerService {
	
	void addCustomer(Customer customer);
	List<Customer> getAllCustomer();
	 
 
}

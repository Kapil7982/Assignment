package com.bookManagement.service;
import java.util.List;

import com.bookManagement.exception.CustomerException;
import com.bookManagement.model.Customer;


public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
	
	public List<Customer> getAllCustomerDetails()throws CustomerException;

}

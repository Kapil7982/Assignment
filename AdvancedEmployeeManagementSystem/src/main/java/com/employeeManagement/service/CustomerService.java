package com.employeeManagement.service;
import java.util.List;

import com.employeeManagement.exception.CustomerException;
import com.employeeManagement.model.Customer;


public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
	
	public List<Customer> getAllCustomerDetails()throws CustomerException;

	public Customer updateCustomer(Customer customer);

	public void deleteCustomer(Integer customerId);

}

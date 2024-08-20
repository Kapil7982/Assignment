package com.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employeeManagement.exception.CustomerException;
import com.employeeManagement.model.Customer;
import com.employeeManagement.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		
		return customerRepository.save(customer);
		
		
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException {
		
		return customerRepository.findByEmail(email).orElseThrow(() -> new CustomerException("Customer Not found with Email: "+email));
	}

	@Override
	public List<Customer> getAllCustomerDetails()throws CustomerException {
		
		List<Customer> customers= customerRepository.findAll();
		
		if(customers.isEmpty())
			throw new CustomerException("No Customer find");
		
		return customers;
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findById(customer.getCustId())
	            .orElseThrow(() -> new CustomerException("Customer not found with ID: " + customer.getCustId()));

	        // Update fields
	        existingCustomer.setName(customer.getName());
	        existingCustomer.setEmail(customer.getEmail());
	        existingCustomer.setAddress(customer.getAddress());

	        // Only update password if it's provided and different
	        if (customer.getPassword() != null && !customer.getPassword().isEmpty() &&
	            !passwordEncoder.matches(customer.getPassword(), existingCustomer.getPassword())) {
	            existingCustomer.setPassword(passwordEncoder.encode(customer.getPassword()));
	        }

	        // Don't update role here for security reasons
	        // If role update is needed, create a separate method with proper authorization

	        return customerRepository.save(existingCustomer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new CustomerException("Customer not found with ID: " + customerId));

	        customerRepository.delete(customer);
		
	}

}

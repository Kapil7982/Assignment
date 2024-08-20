package com.employeeManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagement.model.Customer;
import com.employeeManagement.service.CustomerService;


@RestController
public class CustomerController {

	
		
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/hello")
	public String testHandler() {
		return "Welcome to Spring Security";
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){

		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		
		Customer registeredCustomer= customerService.registerCustomer(customer);
		
		return new ResponseEntity<>(registeredCustomer,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getCustomerByEmailHandler(@PathVariable("email") String email){
		
		
		Customer customer= customerService.getCustomerDetailsByEmail(email);
		
		return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerHandler(){
		
		
		List<Customer> customers= customerService.getAllCustomerDetails();
		
		return new ResponseEntity<>(customers,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/{customerId}")
    @PreAuthorize("hasRole('ADMIN') or #customerId == authentication.principal.id")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer) {
		customer.setCustId(customerId);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

   
    
    @DeleteMapping("/{customerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/profile")
    public ResponseEntity<Customer> getUserProfile(Authentication authentication) {
        String email = authentication.getName();
        Customer customer = customerService.getCustomerDetailsByEmail(email);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity<Customer> updateUserProfile(@RequestBody Customer customer, Authentication authentication) {
        String email = authentication.getName();
        Customer existingCustomer = customerService.getCustomerDetailsByEmail(email);
        customer.setCustId(existingCustomer.getCustId());
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
	
	
}

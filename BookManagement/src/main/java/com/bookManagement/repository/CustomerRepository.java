package com.bookManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookManagement.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByUsername(String username);
	public Optional<Customer> findByEmail(String email);
}

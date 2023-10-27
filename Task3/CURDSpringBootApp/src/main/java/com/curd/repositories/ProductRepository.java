package com.curd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curd.models.Product;

/**
 * Repository interface for performing database operations on products.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}

package com.curd.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.expections.ProductNotFoundException;
import com.curd.models.Product;
import com.curd.repositories.ProductRepository;

/**
 * Service class for managing products.
 */
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

  
    public Product getProductById(Long id) {
        return productRepository.findById(id)
        		.orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product addProduct(Product product) {
        product.setCDate(LocalDateTime.now());
        product.setUDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = getProductById(id);

        if (existingProduct == null) {
            return null; // Handle not found scenario
        }

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setUDate(LocalDateTime.now());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

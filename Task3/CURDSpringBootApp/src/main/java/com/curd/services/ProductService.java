package com.curd.services;

import java.util.List;

import com.curd.models.Product;

public interface ProductService {

	public Product addProduct(Product product);
	public Product getProductById(Long id);
	public List<Product> getAllProducts();
	public Product updateProduct(Long id, Product updatedProduct);
	public void deleteProduct(Long id);
}

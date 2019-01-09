package com.pk.h2test.service;

import java.util.List;

import com.pk.h2test.entity.Product;
import com.pk.h2test.exception.ResourceNotFoundException;

public interface ProductService {
	
	public void saveProduct(Product product);
	public Product create(Product product);
    public Product getProductById(String id) throws ResourceNotFoundException;
    public void updateProduct(Product product);
    public void deleteProduct(String id) throws ResourceNotFoundException;
    public List<Product> getAllProducts();

}

package com.pk.h2test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.h2test.dao.ProductDao;
import com.pk.h2test.entity.Product;
import com.pk.h2test.exception.ResourceNotFoundException;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;

	@Override
	public void saveProduct(Product product) {
		productDao.save(product);
		
	}

	@Override
	public Product getProductById(String id) throws ResourceNotFoundException {
		return productDao.findById(id.toUpperCase()).orElseThrow(()-> new ResourceNotFoundException("Product", "id", id.toUpperCase()));
	}

	@Override
	public void updateProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public void deleteProduct(String id) throws ResourceNotFoundException {
		Product product = productDao.findById(id.toUpperCase()).orElseThrow(()-> new ResourceNotFoundException("Product", "id", id.toUpperCase()));
		productDao.delete(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product create(Product product) {
		
		return productDao.save(product);
	}
	
	
}

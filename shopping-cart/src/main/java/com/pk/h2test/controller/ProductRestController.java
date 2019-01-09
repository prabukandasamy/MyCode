package com.pk.h2test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pk.h2test.entity.Product;
import com.pk.h2test.exception.ResourceNotFoundException;
import com.pk.h2test.service.ProductService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ProductRestController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/create")
    public Product saveProduct(@RequestBody Product product) throws ResourceNotFoundException
    {
        return productService.create(product);
       
    }
    
    
	
}

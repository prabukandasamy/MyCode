package com.pk.h2test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pk.h2test.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, String>{
	
	

}

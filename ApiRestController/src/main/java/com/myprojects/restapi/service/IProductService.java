package com.myprojects.restapi.service;

import java.util.List;
import java.util.Optional;

import com.myprojects.restapi.model.Product;

public interface IProductService {

	List<Product> findAll();
	
	Optional<Product> findById(Long id);
	
	Product save(Product pro);	
	
	Optional<Product> delete(Long id);
	
	Optional<Product> update(Long id, Product pro);	
}

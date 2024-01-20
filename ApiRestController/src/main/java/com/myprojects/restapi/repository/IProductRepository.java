package com.myprojects.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myprojects.restapi.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long>{
	
}

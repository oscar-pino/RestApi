package com.myprojects.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.restapi.model.Product;
import com.myprojects.restapi.repository.IProductRepository;

@Service
public class ProductServiceImp implements IProductService {

	@Autowired
	private IProductRepository pr;

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {

		return pr.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> findById(Long id) {

		return pr.findById(id);
	}

	@Override
	@Transactional
	public Product save(Product pro) {

		return pr.save(pro);
	}

	@Override
	@Transactional
	public Optional<Product> update(Long id, Product pro) {

		Optional<Product> opcional = pr.findById(id);

		if(opcional.isPresent()){

			Product prod = opcional.orElseThrow();
			prod.setName(pro.getName());
			prod.setBrand(pro.getBrand());
			prod.setPrice(pro.getPrice());
			prod.setDescription(pro.getDescription());
			
			return Optional.of(pr.save(prod));
		}

		return opcional;
	}

	@Override
	public Optional<Product> delete(Long id) {

		Optional<Product> opcional = pr.findById(id);

		opcional.ifPresent(prod -> {

			pr.delete(prod);
		});

		return opcional;
	}
}

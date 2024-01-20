package com.myprojects.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.restapi.model.Product;
import com.myprojects.restapi.service.IProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private IProductService ps;
	
	@GetMapping("/automatic_products")
	private String home() {
		
		if(ps.findAll().isEmpty()) {
		Product p = new Product("notebook","acer",1202100.2f, "notebook tipo empresarial");
		ps.save(p);
		p = new Product("estufa","recco",31000f, "bajo consumo de electricidad");
		ps.save(p);
		p = new Product("jostick","sony",52100.2f, "jostick para ps5");
		ps.save(p);
		p = new Product("televisor","lg",521210.2f, "smart tv");
		ps.save(p);
		p = new Product("refrigerador","fensa",721120.2f, "refrigerador de 3 puertas");
		ps.save(p);
		}
		
		return "la lista contiene: "+ps.findAll().size()+" productos";
	}

	
	@GetMapping
	private List<Product> getProducts() {			
		
		return ps.findAll();		
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Product> view(@PathVariable Long id){
		
		Optional<Product> recuperado = ps.findById(id);
		
		if(recuperado.isPresent()) {
			
			return ResponseEntity.ok(recuperado.orElseThrow());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	private ResponseEntity<Product> create(@RequestBody Product pro){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ps.save(pro));
	}
	
	@PutMapping("{id}")
	private ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product pro){
		
		Optional<Product> opcional = ps.findById(id);
		
		if(opcional.isPresent()) {
		
			return ResponseEntity.status(HttpStatus.CREATED).body(ps.update(id, pro).orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<Product> delete(@PathVariable Long id){

		Optional<Product> opcional = ps.findById(id);
		
		if(opcional.isPresent()) {
			
			ps.delete(id);
		
			return ResponseEntity.ok(opcional.orElseThrow());
		}
			
		return ResponseEntity.notFound().build();
	}
	
}

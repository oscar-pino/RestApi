package com.myprojects.restapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="producto_id", nullable=false)	
	private long id;
	
	@NotBlank
	@NotNull	
	private String name;
	
	@NotBlank
	@NotNull
	private String brand;
	
	@DecimalMin(value = "0.00", message = "el precio no debe ser un valor negativo")
	private float price;
	
	@NotBlank
	@NotNull
	private String description;	
	
	public Product() {
		
	}
	
	public Product(String name, String brand, float price, String description) {
		
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.description = description;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", description="
				+ description + "]";
	}	
}

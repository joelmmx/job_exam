package com.job.dto;

import java.util.List;

public class Product {

	/**
	 * reference to agreement or parent product.
	 */
	Object object;
	
	/**
	 * collection of children products.
	 */
	List<Product> products;
	
	/**
	 * string with the product name.
	 */
	private String name;
	
	/**
	 * number with product's price. Can be non integer.
	 */
	private Double price;
	
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

}

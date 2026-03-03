package com.practice.Cache.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Cache.Entity.Product;
import com.practice.Cache.Service.ProductService;

@RestController
public class ProductController {
	
	private ProductService service;

	public ProductController(ProductService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public Product addProduct(Product p) {
		return service.addProduct(p);
	}
	
	@GetMapping("/find-id/{id}")
	public Product findById(int id) {
		return service.getById(id);
	}
	
}

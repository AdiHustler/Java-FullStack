package com.practice.Cache.Service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.practice.Cache.Entity.Product;
import com.practice.Cache.Repos.ProductRepo;

public class ProductService {
	
	private ProductRepo repository;
	
	public ProductService(ProductRepo repository) {
		super();
		this.repository = repository;
	}
	
	@CachePut(cacheNames="product",key="#result.id")
	public Product addProduct(Product p) {
		return repository.save(p);
	}
	
	@Cacheable(cacheNames="product",key="#id")
	public Product getById(int id) {
		return repository.findById(id)
					.orElseThrow(()->new RuntimeException("Id not present."));
	}
	
	@CacheEvict(cacheNames="product",key="#id")
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	
}

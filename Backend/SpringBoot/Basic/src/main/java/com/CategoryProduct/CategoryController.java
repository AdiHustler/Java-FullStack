package com.CategoryProduct;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	@Autowired
	 CategoryJpaRepository categoryjpa;
	
	@PostMapping("/add")
	public Category addCategory(@RequestBody Category c) {
		
		return categoryjpa.save(c);
		
	}
	
	@GetMapping("/categories/{page}/{size}")
	public List<Category> getCategory(@PathVariable int page,@PathVariable int size) {
		
		Page<Category> p=categoryjpa.findAll(PageRequest
				.of(page, size,Sort.by("id").descending()));
		
		return p.getContent();
	}
	
	@GetMapping("/get-id/{id}")
	public ResponseEntity getById(@PathVariable int id) {
		Optional<Category> option = categoryjpa.findById(id);
		Category c = null;
		if(option.isPresent()) {
			c=option.get();
			return new ResponseEntity<Category>(c,HttpStatus.FOUND);
		}
		throw new CategoryNotFoundException("Category not found Id: "+id);
	}
	
}


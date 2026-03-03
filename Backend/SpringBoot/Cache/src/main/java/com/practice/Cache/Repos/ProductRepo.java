package com.practice.Cache.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.Cache.Entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{

}

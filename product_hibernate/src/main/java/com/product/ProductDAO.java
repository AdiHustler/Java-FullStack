package com.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductDAO {
	
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
	
	EntityManager em = emf.createEntityManager();
	
	public String insertProduct(Product p) {
		EntityTransaction et = em.getTransaction();
		if(p!=null) {
			et.begin();
			em.persist(p);
			et.commit();
			return "Product inserted";
		}
		else {
			return "Invalid product";
		}
		
	}
	public Product findById(int id) {
		Product p=em.find(Product.class, id);
		return p;
	}
	public boolean deleteProduct(int id) {
		Product p=findById(id);
		
		if(p!=null) {
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.remove(p);
			et.commit();
			return true;
		}
		
		else {
			return false;
		}
	}


}

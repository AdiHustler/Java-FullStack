package com.basics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
	EntityManager em=emf.createEntityManager();
	
	public void insertUsers() {
		EntityTransaction et = em.getTransaction();
		User user = new User();
		et.begin();
		user.setId(1);
		user.setName("Billo");
		user.setBalance(1000);
		em.persist(user);
		et.commit();
	}
	
	public User findById(int id) {
		return em.find(User.class, 1);
	}
}

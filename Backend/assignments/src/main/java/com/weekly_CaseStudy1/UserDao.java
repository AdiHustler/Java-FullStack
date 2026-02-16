package com.weekly_CaseStudy1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	public void saveUser(User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(u);
		tx.commit();
	}
	
	public User findUser(long id) {
	    EntityManager em = emf.createEntityManager();
	
	    User user = em.find(User.class, id);
	    if (user != null) {
	    	user.getP().getId();
	    }
	
	    em.close();
	    return user;
	}
	
	public void deleteUser(long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User u = em.find(User.class, id);
		if(u!=null) {
			em.remove(u);
		}
		tx.commit();
		em.close();
	}
	
	public void updateUser(User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		User user = em.find(User.class,u.getId());
		
		if(user!=null) {
			user.setName(u.getName());
		}
		
		// Could also use merge
		// em.merge(u);
		tx.commit();
		
	}
}
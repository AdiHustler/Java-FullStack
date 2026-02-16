package com.weekly_CaseStudy1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderDao {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	 public void saveOrder(PurchaseOrder o) {
	  
	  EntityManager em = emf.createEntityManager();
	  EntityTransaction et = em.getTransaction();
	  
	  et.begin();
	  em.persist(o);
	  et.commit();
	  
	  em.close();
	 }
	 
	 public PurchaseOrder findOrder(long id) {
	  EntityManager em = emf.createEntityManager();
	
	  PurchaseOrder po = em.find(PurchaseOrder.class, id);
	  
	  if(po!=null) {
	   po.getOrderDate();
	  }
	  
	  em.close();
	  return po;
	  
	 }
	 
	 public User findOrdersByUser(long userid) {
	  EntityManager em = emf.createEntityManager();
	  User u = em.find(User.class, userid);
	  if(u!=null) {
	   u.getP().getId();
	  }
	  em.close();
	  return u;
	
	 }
}
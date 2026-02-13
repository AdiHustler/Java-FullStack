package com.OnetoOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User {

	public static void main(String[] args) {
			findByCarId();
			deleteEngine();
	}
	public static void findByCarId() {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();


	Car c=em.find(Car.class,1);
	System.out.println(c);

	}

	public static void deleteEngine() {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();


	et.begin();

	// String sql="UPDATE CAR UPDATE CAR WHERE ENGINE_ID = ?";
	String jpql="update Car c set c.engine = null where c.engine.eid = ?1";
	Query query=em.createQuery(jpql);
	query.setParameter(1, 100);
	query.executeUpdate();


	Engine e=em.find(Engine.class, 100);

	if (e != null) {
	       em.remove(e);
	   }

	et.commit();


	}

	public static void insertCarAndEngine(){
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();

	Engine e=new Engine();
	e.setId(100);
	e.setType("V8");
	e.setFuelType("Petrol");
	e.setMilege(12);
	e.setCc(3000);


	Car c=new Car();
	c.setId(1);
	c.setBrand("BMW");
	c.setModel("M5");
	c.setModelYear("2022");
	c.setPrice(20000000);

	c.setEngine(e);

	et.begin();
	em.persist(c);
	em.persist(e);
	et.commit();

	}
}


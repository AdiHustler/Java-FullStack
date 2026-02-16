package com.OnetoMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		College c =em.find(College.class, 1);
		Student s1 = new Student();
		s1.setStudentId(101);
		s1.setName("Thomas");
		s1.setBranch("CSE");
		
		Student s2 = new Student();
		s2.setStudentId(102);
		s2.setName("John");
		s2.setBranch("ECE");
		
		Student s3 = new Student();
		s3.setStudentId(105);
		s3.setName("Lisa");
		s3.setBranch("MBA");
		
//		College c = new College();
//		c.setId(1);
//		c.setName("LPU");
//		c.setLocation("Phagwara");
//		c.setPincode("14001");
//		
//		List<Student> list = new ArrayList<>();
		
		List<Student> list = c.getS();
		list.add(s3);
		c.setS(list);
		
		tx.begin();
		em.persist(s3);
		tx.commit();
		
	}
}

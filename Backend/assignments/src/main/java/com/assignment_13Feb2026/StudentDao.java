package com.assignment_13Feb2026;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDao {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	public void saveAadharcard(AadharCard card) {
		EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	
	    tx.begin();
	    em.persist(card);
	    tx.commit();
	    em.close();
	}
	
	// Save HostelRoom
	public void saveHostelRoom(HostelRoom room) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	
	    tx.begin();
	    em.persist(room);
	    tx.commit();
	    em.close();
	}
	
	// Save Student
	public void saveStudent(Student student) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	
	    tx.begin();
	    em.persist(student);
	    tx.commit();
	    em.close();
	}
	
	// Fetch Student with all details
	public Student getStudent(int id) {
	    EntityManager em = emf.createEntityManager();
	
	    Student student = em.find(Student.class, id);
	    if (student != null) {
	        student.getAc().getAadharNumber();
	        student.getHr().getRoomNumber();
	    }
	
	    em.close();
	    return student;
	}
	
	// Delete Student
	public void deleteStudent(int id) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	
	    tx.begin();
	    Student student = em.find(Student.class, id);
	    if (student != null) {
	        em.remove(student);
	    }
	    tx.commit();
	    em.close();
	}
}

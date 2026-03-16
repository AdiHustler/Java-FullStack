package com.prac;
import javax.persistence.*;

public class InstructorDAO {
	
	private EntityManager em;
	
	InstructorDAO(EntityManager em){
		this.em = em;
	}
	
	public void saveInstructor(Instructor inst) {
		em.getTransaction().begin();
		em.persist(inst);
		em.getTransaction().commit();
	}
	
	public Instructor findInstructor(int id) {
		return em.find(Instructor.class, id);
		
	}
	
	public void updateInstructor(Instructor inst) {
		em.getTransaction().begin();
		em.merge(inst);
		em.getTransaction().commit();
	}
	
	public void deleteInstructor(int id) {
	    em.getTransaction().begin();
	    Instructor i = em.find(Instructor.class, id);
	    em.remove(i);
	    em.getTransaction().commit();
	}

}

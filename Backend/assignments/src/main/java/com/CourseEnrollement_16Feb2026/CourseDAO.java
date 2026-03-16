package com.prac;
import javax.persistence.*;
import java.util.*;
public class CourseDAO {
	private EntityManager em;
	
	CourseDAO(EntityManager em){
		this.em = em;
	}
	
	public void saveCourse(Course c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	public Course findCourse(int id) {
		return em.find(Course.class, id);
	}
	
	public List<Course> findByInstructor(int id) {
		Instructor i = em.find(Instructor.class, id);
		return i.getCourses();
	}
}

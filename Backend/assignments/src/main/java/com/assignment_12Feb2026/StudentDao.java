package com.assignment_12Feb2026;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	private EntityManager em;

    public StudentDao(EntityManager em) {
        this.em = em;
    }
	
	public void saveStudent(Student s) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(s);
        tx.commit();

        em.close();
	}
		
	public Student findStudentById(int id) {
		Student student = em.find(Student.class, id);
        em.close();
        return student;
	}

	public List<Student> findAllStudent() {
		EntityTransaction tx = em.getTransaction();
	    tx.begin();

	    String jpqlQuery = "SELECT s FROM Student s";

	    Query q = em.createQuery(jpqlQuery);

	    List<Student> resultList = q.getResultList();

	    List<Student> studentList = resultList;

	    tx.commit();

	    em.close();

	    return studentList;
	}
	
	public void updateStudent(Student s) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(s);
        tx.commit();

        em.close();
	}

	public void deleteStudent(int id) {
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();

        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }

        tx.commit();
        em.close();
	}
	
	public int getStudentCount() {
	    Query q = em.createQuery("SELECT COUNT(s) FROM Student s");
	    Long count = (Long) q.getSingleResult();
	    return count.intValue();
	}


	public List<Student> findStudentsWithMarksGreaterThan80() {
	    Query q = em.createQuery("SELECT s FROM Student s WHERE s.marks > 80");
	    List<Student> ans=q.getResultList();
	    return ans;
	}

}
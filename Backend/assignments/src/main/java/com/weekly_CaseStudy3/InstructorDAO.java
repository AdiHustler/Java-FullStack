package com.weekly_CaseStudy3;

import javax.persistence.*;

public class InstructorDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveInstructor(Instructor i) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(i);
        tx.commit();

        em.close();
    }

    public Instructor findInstructor(long id) {

        EntityManager em = emf.createEntityManager();
        Instructor i = em.find(Instructor.class, id);

        if (i != null && i.getCourses() != null)
            i.getCourses().size();

        em.close();
        return i;
    }

    public void updateInstructor(Instructor i) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(i);
        tx.commit();

        em.close();
    }

    public void deleteInstructor(long id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Instructor i = em.find(Instructor.class, id);

        if (i != null) {
            tx.begin();
            em.remove(i);
            tx.commit();
        }

        em.close();
    }
}

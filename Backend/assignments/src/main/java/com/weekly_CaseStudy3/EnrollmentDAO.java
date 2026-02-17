package com.weekly_CaseStudy3;

import javax.persistence.*;

public class EnrollmentDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveEnrollment(Enrollment e) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(e);
        tx.commit();

        em.close();
    }

    public void updateGrade(long id, String grade) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Enrollment e = em.find(Enrollment.class, id);

        if (e != null) {
            tx.begin();
            e.setGrade(grade);
            tx.commit();
        }

        em.close();
    }
}

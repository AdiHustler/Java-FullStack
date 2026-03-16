package com.prac;
import javax.persistence.*;

public class EnrollmentDAO {

    private EntityManager em;

    public EnrollmentDAO(EntityManager em) {
        this.em = em;
    }

    public void saveEnrollment(Enrollment enrollment) {
        em.getTransaction().begin();
        em.persist(enrollment);
        em.getTransaction().commit();
    }

    public void updateGrade(int id, String grade) {
        em.getTransaction().begin();
        Enrollment e = em.find(Enrollment.class, id);
        e.setGrade(grade);
        em.getTransaction().commit();
    }
}


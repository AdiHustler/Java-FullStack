package com.weekly_CaseStudy2;

import javax.persistence.*;

public class DoctorDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveDoctor(Doctor d) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(d);
        tx.commit();

        em.close();
    }

    public Doctor findDoctor(long id) {

        EntityManager em = emf.createEntityManager();

        Doctor d = em.find(Doctor.class, id);

        if (d != null && d.getAppointments() != null) {
            d.getAppointments().size(); // force load
        }

        em.close();
        return d;
    }

    public void updateDoctor(Doctor d) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(d);
        tx.commit();

        em.close();
    }

    public void deleteDoctor(long id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Doctor d = em.find(Doctor.class, id);

        if (d != null) {
            tx.begin();
            em.remove(d);
            tx.commit();
        }

        em.close();
    }
}

package com.weekly_CaseStudy2;

import javax.persistence.*;

public class PatientDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void savePatient(Patient p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(p);
        tx.commit();
        em.close();
    }

    public Patient findPatient(long id) {
        EntityManager em = emf.createEntityManager();
        Patient p = em.find(Patient.class, id);
        em.close();
        return p;
    }

    public void updatePatient(Patient p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(p);
        tx.commit();
        em.close();
    }

    public void deletePatient(long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Patient p = em.find(Patient.class, id);

        if (p != null) {
            tx.begin();
            em.remove(p);
            tx.commit();
        }

        em.close();
    }
}

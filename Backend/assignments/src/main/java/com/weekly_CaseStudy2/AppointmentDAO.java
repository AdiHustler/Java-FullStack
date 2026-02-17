package com.weekly_CaseStudy2;

import java.util.List;

import javax.persistence.*;

public class AppointmentDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveAppointment(Appointment a) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(a);
        tx.commit();

        em.close();
    }

    public Appointment findAppointment(long id) {

        EntityManager em = emf.createEntityManager();

        Appointment a = em.find(Appointment.class, id);

        em.close();
        return a;
    }

    public List<Appointment> findAppointmentByDoctor(long doctorId) {

        EntityManager em = emf.createEntityManager();

        Doctor d = em.find(Doctor.class, doctorId);

        List<Appointment> list = null;

        if (d != null) {
            list = d.getAppointments();
            list.size(); // force load
        }

        em.close();
        return list;
    }

    public void updateFee(long id, double newFee) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Appointment a = em.find(Appointment.class, id);

        if (a != null) {
            tx.begin();
            a.setFee(newFee);
            tx.commit();
        }

        em.close();
    }

    public void updateAppointment(Appointment a) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(a);
        tx.commit();

        em.close();
    }
}

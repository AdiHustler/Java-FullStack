package com.prac;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public static void main(String[] args) {

        task1();
        // task2();
        // task3();
        // task4();
        // task5();

        emf.close();
    }

   
    // Patient → MedicalRecord (OneToOne)
    static void task1() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        MedicalRecord record = new MedicalRecord();
        record.setRecordDate(LocalDate.now());
        record.setDiagnosis("Flu");
        record.setNotes("Rest 3 days");

        Patient patient = new Patient();
        patient.setName("Garv");
        patient.setDob(LocalDate.of(2004, 1, 1));
        patient.setBloodGroup("B+");
        patient.setPhoneNumber("9999999999");

        patient.setMedicalRecord(record);

        em.persist(patient);

        em.getTransaction().commit();

        Long id = patient.getId();

        // READ
        Patient p = em.find(Patient.class, id);
        System.out.println("Diagnosis: " + p.getMedicalRecord().getDiagnosis());

        // UPDATE
        em.getTransaction().begin();
        p.getMedicalRecord().setNotes("Updated: Follow-up required");
        em.getTransaction().commit();

        // DELETE
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        em.close();
    }

  
    // Department ↔ Doctor (Bidirectional OneToMany)
    static void task2() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Department d1 = new Department();
        d1.setName("Cardiology");

        Department d2 = new Department();
        d2.setName("Neurology");

        Doctor doc1 = new Doctor();
        doc1.setName("Dr A");

        Doctor doc2 = new Doctor();
        doc2.setName("Dr B");

        Doctor doc3 = new Doctor();
        doc3.setName("Dr C");

        Doctor doc4 = new Doctor();
        doc4.setName("Dr D");

        d1.addDoctor(doc1);
        d1.addDoctor(doc2);

        d2.addDoctor(doc3);
        d2.addDoctor(doc4);

        em.persist(d1);
        em.persist(d2);

        em.getTransaction().commit();

        
        Department dept = em.find(Department.class, d1.getId());
        for (Doctor d : dept.getDoctors()) {
            System.out.println(d.getName());
        }

        em.close();
    }

   
    // Doctor → Appointment (Unidirectional OneToMany)
    static void task3() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Doctor doctor = new Doctor();
        doctor.setName("Dr X");

        Appointment a1 = new Appointment();
        a1.setAppointDate(LocalDateTime.now());
        a1.setStatus("SCHEDULED");

        Appointment a2 = new Appointment();
        a2.setAppointDate(LocalDateTime.now().plusDays(1));
        a2.setStatus("COMPLETED");

        Appointment a3 = new Appointment();
        a3.setAppointDate(LocalDateTime.now().plusDays(2));
        a3.setStatus("CANCELLED");

        doctor.getAppointments().add(a1);
        doctor.getAppointments().add(a2);
        doctor.getAppointments().add(a3);

        em.persist(doctor);

        em.getTransaction().commit();

        em.close();
    }

    
    // Appointment → Prescription (OneToOne)
    static void task4() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Prescreption p = new Prescreption();
        p.setMedicines("Paracetamol");
        p.setDosage("2 times");
        p.setIssuedDate(LocalDate.now());

        Appointment a = new Appointment();
        a.setAppointDate(LocalDateTime.now());
        a.setStatus("COMPLETED");

        a.setPrescreption(p);

        em.persist(a);

        em.getTransaction().commit();

        em.close();
    }

  
    // Doctor ↔ Patient (ManyToMany)
    static void task5() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Doctor d1 = new Doctor();
        d1.setName("Dr Mehta");

        Doctor d2 = new Doctor();
        d2.setName("Dr Singh");

        Patient p1 = new Patient();
        p1.setName("Ali");

        Patient p2 = new Patient();
        p2.setName("Priya");

        Patient p3 = new Patient();
        p3.setName("Raj");

        d1.addPatient(p1);
        d1.addPatient(p2);

        d2.addPatient(p1);
        d2.addPatient(p3);

        em.persist(d1);
        em.persist(d2);

        em.getTransaction().commit();

       
        Doctor d = em.find(Doctor.class, d1.getId());
        List<Patient> patients = d.getPatients();

        for (Patient p : patients) {
            System.out.println(p.getName());
        }

        em.close();
    }
}
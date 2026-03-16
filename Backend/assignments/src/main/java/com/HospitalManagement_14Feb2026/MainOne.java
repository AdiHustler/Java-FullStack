package com.prac;
import javax.persistence.*;
import java.time.*;
public class MainOne {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	public static void main(String []args) {
		task1();
	}
	static void task1() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		MedicalRecord med = new MedicalRecord();
		med.setRecordDate(LocalDate.now());
		med.setDiagnosis("Flu");
		med.setNotes("Rest 3 days");
		
		Patient p = new Patient();
		p.setName("aryan");
		p.setBloodGroup("B+");
		p.setDob(LocalDate.of(2004, 10, 10));
		p.setMedicalRecord(med);
		
		em.persist(p);
		em.getTransaction().commit();
		
		long id = p.getId();
		Patient p1 = em.find(Patient.class, id);
		System.out.println(p1.getMedicalRecord().getDiagnosis());
		
		MedicalRecord m1 = em.find(MedicalRecord.class, 1L);
		System.out.println(m1.getDiagnosis());
		
		em.getTransaction().begin();
		em.remove(p1);
		em.getTransaction().commit();
		
	
		
		
	}
}

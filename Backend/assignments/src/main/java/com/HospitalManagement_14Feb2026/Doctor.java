package com.prac;
import javax.persistence.*;
import java.util.*;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String specialization;
	private String LicenseNo;
	
	@ManyToMany
	@JoinTable(
	    name = "patient_doctors",
	    joinColumns = @JoinColumn(name="doctor_id"),       
	    inverseJoinColumns = @JoinColumn(name ="patient_id") 
	)
	private List<Patient> patients;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Department department;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private List<Appointment>appointments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getLicenseNo() {
		return LicenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		LicenseNo = licenseNo;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	public void addPatient(Patient p) {
		patients.add(p);
	}
	
}

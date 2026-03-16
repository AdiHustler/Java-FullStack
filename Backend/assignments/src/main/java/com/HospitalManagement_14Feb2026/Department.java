package com.prac;
import javax.persistence.*;
import java.util.*;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String Location;
	private String headDoctorName;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
	private List<Doctor>doctors;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getHeadDoctorName() {
		return headDoctorName;
	}

	public void setHeadDoctorName(String headDoctorName) {
		this.headDoctorName = headDoctorName;
	}

	public List<Doctor> getDoctor() {
		return doctors;
	}

	public void setDoctor(List<Doctor> doctor) {
		this.doctors = doctor;
	}
	
	public void addDoctor(Doctor d) {
		doctors.add(d);
	}
	
	public List<Doctor> getDoctors(){
		return doctors;
	}
}

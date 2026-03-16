package com.prac;
import javax.persistence.*;
import java.util.*;
@Entity
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String department;
	
	@OneToOne(cascade = CascadeType.ALL)
	private InstructorProfile ip;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Course>courses = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public InstructorProfile getIp() {
		return ip;
	}

	public void setIp(InstructorProfile ip) {
		this.ip = ip;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}

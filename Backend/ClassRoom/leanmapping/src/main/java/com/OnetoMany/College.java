package com.OnetoMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {
	
	@Id
	private int id;
	private String name;
	private String location;
	private String pincode;
	
	@OneToMany
	private List<Student> s;
	

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<Student> getS() {
		return s;
	}

	public void setS(List<Student> s) {
		this.s = s;
	}

	
}

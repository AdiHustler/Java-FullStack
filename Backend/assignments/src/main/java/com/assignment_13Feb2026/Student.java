package com.assignment_13Feb2026;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="Student13")
public class Student {
	
	@Id
	private int studentId;
	private String name;
	private String email;
	private String branch;
	
	@OneToOne
	private AadharCard ac ;
	@OneToOne
	private HostelRoom hr ;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public AadharCard getAc() {
		return ac;
	}
	public void setAc(AadharCard ac) {
		this.ac = ac;
	}
	public HostelRoom getHr() {
		return hr;
	}
	public void setHr(HostelRoom hr) {
		this.hr = hr;
	}
	
	
}

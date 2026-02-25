package com.CrmAssesment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.*;

@Entity
public class SalesEmployee{

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String department;
    
    
    protected SalesEmployee() {
    }
    
    public SalesEmployee(Long id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	@OneToMany(cascade = CascadeType.ALL)
    private List<Lead> leads;

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Lead> getLeads() {
		return leads;
	}

	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}
}

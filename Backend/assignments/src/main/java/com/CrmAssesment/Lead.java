package com.CrmAssesment;

import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Lead{

    @Id
    @GeneratedValue
    private Long leadId;

    private String source;
    private String status;

    @ManyToOne
    private SalesEmployee employee;

    
    @ManyToOne
    private Customer customer;


	public Long getLeadId() {
		return leadId;
	}


	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public SalesEmployee getEmployee() {
		return employee;
	}


	public void setEmployee(SalesEmployee employee) {
		this.employee = employee;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    
}
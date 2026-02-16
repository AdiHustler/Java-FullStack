package com.weekly_CaseStudy1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	private long id;
	private String name;
	private String email;
	@OneToOne
	Profile p;
	@OneToMany
	List<PurchaseOrder> purchase = new ArrayList<>();
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Profile getP() {
		return p;
	}
	public void setP(Profile p) {
		this.p = p;
	}
	public List<PurchaseOrder> getPurchase() {
		return purchase;
	}
	public void setPurchase(List<PurchaseOrder> purchase) {
		this.purchase = purchase;
	}
	
	
	
}

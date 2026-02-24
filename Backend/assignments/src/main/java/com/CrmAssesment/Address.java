package com.CrmAssesment;

import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long address_id;
	private String city;
	private String state;
	private String pincode;
	
	public Address() {
		this.address_id = address_id;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public SalesEmployee getSalesemp() {
		return salesemp;
	}

	public void setSalesemp(SalesEmployee salesemp) {
		this.salesemp = salesemp;
	}
	@ManyToOne
	private SalesEmployee salesemp;

	
}

package com.weekly_CaseStudy1;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PurchaseOrder {
	
	@Id
	private int id;
	private Date orderDate;
	private int total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}

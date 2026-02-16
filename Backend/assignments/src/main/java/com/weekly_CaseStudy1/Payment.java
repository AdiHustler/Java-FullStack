package com.weekly_CaseStudy1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Payment {
	
	@Id
	private int id;
	private String mode;
	private int amount;
	
	@ManyToOne
	PurchaseOrder purchase;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public PurchaseOrder getPurchase() {
		return purchase;
	}

	public void setPurchase(PurchaseOrder purchase) {
		this.purchase = purchase;
	}
	
	
}

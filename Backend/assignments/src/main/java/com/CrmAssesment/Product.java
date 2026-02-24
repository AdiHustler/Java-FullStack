package com.CrmAssesment;
import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;

    private String productName;
    private double price;
    
    
	public Product() {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

    
}
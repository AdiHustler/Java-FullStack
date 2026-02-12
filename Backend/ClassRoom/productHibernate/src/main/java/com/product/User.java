package com.product;
import javax.persistence.*;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();

		Product pro = new Product();

		

		pro.setId(1);
 
		pro.setName("Pen");

		pro.setPrice(10);

		pro.setQuantity(5);
		
		
		

	}

}

package com.basics;

public class Main {

	public static void main(String[] args) {
		UserDao u = new UserDao();
		
		u.insertUsers();
		u.findById(1);
	}

}

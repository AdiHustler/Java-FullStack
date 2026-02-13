package com.basics;

// This is the service layer of the project
// All the business logic will be written here i.e DSA part and the calculations

public class UserService {
	
	UserDao dao;
	
	public UserService(UserDao dao){
		this.dao=dao;
	}
	
	public String typeOfUser(int id) {
		User u = dao.findById(id);
		
		if(u.getBalance()>0 && u.getBalance()<=1000) {
			return "New User";
		}else if(u.getBalance()>1000 && u.getBalance()<=2000) {
			return "Regular User";
		}else {
			return "Premium User";
		}
		
	}
}

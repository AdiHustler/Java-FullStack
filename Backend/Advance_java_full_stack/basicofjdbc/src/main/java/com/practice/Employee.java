package com.practice;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String branch;
	
	public Employee(int id,String name,int age,String branch) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.branch=branch;
	}
	
	public boolean isValidAge() {
		if(age>17) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

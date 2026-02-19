package com.stream_revision;

public class Employee {
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", designation=" + designation + ", salary=" + salary + ", city=" + city + ", email="
				+ email + ", phone=" + phone + "]";
	}
	private int empId;
    private String name;
    private int age;
    private String gender;
    private String department;
    private String designation;
    private double salary;
    private String city;
    private String email;
    private String phone;
	public Employee(int empId, String name, int age, String gender, String department, String designation,
			double salary, String city, String email, String phone) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
		this.email = email;
		this.phone = phone;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

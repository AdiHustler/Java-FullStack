package com.stream_revision;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main1 {
	public static void main(String[] args) {
		
		
		List<Employee> employee = getEmployee();
		
		maxSal();
		
	}
	
	public static void maxSal(){
		Double max = getEmployee().stream()
									.mapToDouble(e->e.getSalary())
									.max().orElse(0);
		System.out.println(max);
		
		List<Employee> res = getEmployee().stream()
											.filter(emp->emp.getSalary()==max)
											.collect(Collectors.toList());
		System.out.println(res);
	}
	
	public static List<Employee> getEmployee(){
		 List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(101, "Arjun Kumar", 28, "Male", "IT",
                "Software Engineer", 55000, "Chennai",
                "arjun.kumar@gmail.com", "9876543210"));

        employeeList.add(new Employee(102, "Priya Sharma", 30, "Female", "HR",
                "HR Manager", 60000, "Bangalore",
                "priya.sharma@gmail.com", "9876543211"));

        employeeList.add(new Employee(103, "Rahul Verma", 26, "Male", "IT",
                "QA Engineer", 45000, "Hyderabad",
                "rahul.verma@gmail.com", "9876543212"));

        employeeList.add(new Employee(104, "Sneha Reddy", 32, "Female", "Finance",
                "Accountant", 52000, "Mumbai",
                "sneha.reddy@gmail.com", "9876543213"));

        employeeList.add(new Employee(105, "Vikram Singh", 35, "Male", "Sales",
                "Sales Manager", 70000, "Delhi",
                "vikram.singh@gmail.com", "9876543214"));

        employeeList.add(new Employee(106, "Kavya Nair", 27, "Female", "IT",
                "Backend Developer", 58000, "Kochi",
                "kavya.nair@gmail.com", "9876543215"));

        employeeList.add(new Employee(107, "Aditya Rao", 29, "Male", "Marketing",
                "Marketing Analyst", 48000, "Pune",
                "aditya.rao@gmail.com", "9876543216"));

        employeeList.add(new Employee(108, "Meera Iyer", 31, "Female", "IT",
                "Frontend Developer", 56000, "Chennai",
                "meera.iyer@gmail.com", "9876543217"));

        employeeList.add(new Employee(109, "Karan Mehta", 34, "Male", "Finance",
                "Financial Analyst", 65000, "Ahmedabad",
                "karan.mehta@gmail.com", "9876543218"));

        employeeList.add(new Employee(110, "Divya Patel", 25, "Female", "Support",
                "Support Executive", 40000, "Surat",
                "divya.patel@gmail.com", "9876543219"));

        employeeList.add(new Employee(111, "Rohit Gupta", 33, "Male", "IT",
                "Team Lead", 75000, "Noida",
                "rohit.gupta@gmail.com", "9876543220"));

        employeeList.add(new Employee(112, "Anjali Desai", 28, "Female", "Sales",
                "Sales Executive", 47000, "Vadodara",
                "anjali.desai@gmail.com", "9876543221"));

        employeeList.add(new Employee(113, "Suresh Babu", 36, "Male", "Operations",
                "Operations Manager", 72000, "Coimbatore",
                "suresh.babu@gmail.com", "9876543222"));

        employeeList.add(new Employee(114, "Neha Joshi", 29, "Female", "HR",
                "Recruiter", 46000, "Jaipur",
                "neha.joshi@gmail.com", "9876543223"));

        employeeList.add(new Employee(115, "Manish Yadav", 27, "Male", "IT",
                "DevOps Engineer", 62000, "Gurgaon",
                "manish.yadav@gmail.com", "9876543224"));
        
        return employeeList;
	}
}

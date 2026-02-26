package com.SpringBoot_26Feb2026;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import jakarta.validation.constraints.PositiveOrZero;

import jakarta.validation.constraints.PositiveOrZero;

import jakarta.validation.constraints.PositiveOrZero;


@Entity
@Table(name = "employees",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Employee {

    @Id
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;
    
    @PositiveOrZero(message = "Salary cannot be negative")
    private double salary;

    private String department;

    public Employee() {}

    public Employee(String name, String email, double salary, String department) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() { 
    	return id; 
    }

    public void setId(Long id) { 
    	this.id=id; 
    }

    public String getName() { 
    	return name; 
    }

    public void setName(String name) { 
    	this.name=name; 
    }

    public String getEmail() { 
    	return email; 
    }

    public void setEmail(String email) { 
    	this.email = email; 
    }

    public double getSalary() { 
    	return salary; 
    }

    public void setSalary(double salary) { 
    	this.salary=salary; 
    }

    public String getDepartment() { 
    	return department; 
    }

    public void setDepartment(String department) { 
    	this.department=department; 
    }
}
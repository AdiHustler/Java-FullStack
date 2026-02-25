package com.capgemini.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dto.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	EntityManager entityManager;
	
	public void insert(Employee e) {
		entityManager.getTransaction().begin();
		if(find(e.getId())==null) {
			entityManager.persist(e);
		}
		else {
			System.out.print("Employee already exists!!!");
		}
		entityManager.getTransaction().commit();
	}
	
	public Employee find(int id) {
		return entityManager.find(Employee.class, id);
	}
}

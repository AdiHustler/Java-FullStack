package com.SpringBoot_26Feb2026;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee createEmployee(Employee employee) {
    	if (repository.existsByEmail(employee.getEmail())) {
            return null; 
        }
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(employee.getName());
            existing.setEmail(employee.getEmail());
            existing.setSalary(employee.getSalary());
            existing.setDepartment(employee.getDepartment());
            return repository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Employee> getByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    @Override
    public List<Employee> getBySalaryGreaterThan(double salary) {
        return repository.findBySalaryGreaterThan(salary);
    }

    @Override
    public long countEmployees() {
        return repository.count();
    }

    @Override
    public List<Employee> sortBySalary() {
        return repository.findAll(Sort.by("salary"));
    }

    @Override
    public Page<Employee> paginate(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Employee> getSalaryAboveAverage() {
        return repository.findEmployeesWithSalaryAboveAverage();
    }

}
package com.SpringBoot_26Feb2026;

import java.util.List;
import org.springframework.data.domain.Page;

public interface EmployeeService {
	
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    List<Employee> getByDepartment(String department);

    List<Employee> getBySalaryGreaterThan(double salary);

    long countEmployees();

    List<Employee> sortBySalary();

    Page<Employee> paginate(int page, int size);

    List<Employee> getSalaryAboveAverage();
}
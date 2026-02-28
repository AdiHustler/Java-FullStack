package com.SpringBoot_26Feb2026;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee create(@Valid @RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id,@RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }

    @GetMapping("/department/{name}")
    public List<Employee> byDepartment(@PathVariable String name) {
        return service.getByDepartment(name);
    }

    @GetMapping("/highsalary")
    public List<Employee> highSalary(@RequestParam double value) {
        return service.getBySalaryGreaterThan(value);
    }

    @GetMapping("/sort")
    public List<Employee> sortBySalary() {
        return service.sortBySalary();
    }

    @GetMapping("/page")
    public Page<Employee> paginate(@RequestParam int page,@RequestParam int size) {
        return service.paginate(page, size);
    }

    @GetMapping("/count")
    public long count() {
        return service.countEmployees();
    }

    @GetMapping("/above-average")
    public List<Employee> aboveAverage() {
        return service.getSalaryAboveAverage();
    }
}
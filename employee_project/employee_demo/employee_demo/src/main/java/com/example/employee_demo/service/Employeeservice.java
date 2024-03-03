package com.example.employee_demo.service;

import com.example.employee_demo.entity.Employee;

import java.util.List;

public interface Employeeservice {
    public List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theemployee);
    void deleteById(int theId);
}

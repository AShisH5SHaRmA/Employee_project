package com.example.employee_demo.dao;

import com.example.employee_demo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findaAll();
    Employee findById(int theId);
    Employee save(Employee theemployee);
    void deleteById(int theId);
}

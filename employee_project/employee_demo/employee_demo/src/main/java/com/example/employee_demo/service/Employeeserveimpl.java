package com.example.employee_demo.service;

import com.example.employee_demo.dao.EmployeeDao;
import com.example.employee_demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Employeeserveimpl implements Employeeservice{
    private EmployeeDao employeeDao;
    @Autowired
    public Employeeserveimpl(EmployeeDao theemployeeDao) {
        employeeDao = theemployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findaAll();
    }
    @Transactional
    @Override
    public Employee findById(int theId) {
        return employeeDao.findById(theId);
    }
    @Transactional
    @Override
    public Employee save(Employee theemployee) {
        return employeeDao.save(theemployee);
    }

    @Override
    public void deleteById(int theId) {
       employeeDao.deleteById(theId);
    }
}

package com.example.employee_demo.dao;

import com.example.employee_demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoimpl implements EmployeeDao{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDaoimpl(EntityManager theentityManager) {
        entityManager = theentityManager;
    }

    @Override
    public List<Employee> findaAll() {
        TypedQuery<Employee>thequery=entityManager.createQuery("From Employee",Employee.class);
        List<Employee>result=thequery.getResultList();
        return result;
    }

    @Override
    public Employee findById(int theId) {

        // get employee
        Employee theemployee=entityManager.find(Employee.class,theId);

        //return employee
        return theemployee;
    }

    @Override
    public Employee save(Employee theemployee) {
        // save employee
        Employee dbemployee=entityManager.merge(theemployee);
        // return the dbemployee
        return dbemployee;
    }

    @Override
    public void deleteById(int theId) {
      Employee theemployee=entityManager.find(Employee.class,theId);
      entityManager.remove(theemployee);
    }
}

package com.example.employee_demo.rest;

import com.example.employee_demo.dao.EmployeeDao;
import com.example.employee_demo.entity.Employee;
import com.example.employee_demo.service.Employeeservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Employeerestcontroller {
    private Employeeservice employeeservice;

    public Employeerestcontroller(Employeeservice theemployeeservice) {
        employeeservice = theemployeeservice;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeservice.findAll();
    }
    // add mapping for GET / employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theemployee=employeeservice.findById(employeeId);
        if(theemployee==null)
            throw new RuntimeException("Employee id not found"+employeeId);
        return theemployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theemployee){
        theemployee.setId(0);
        Employee dbemployee=employeeservice.save(theemployee);
        return dbemployee;
    }
    @PutMapping("/employee")
    public Employee putEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeservice.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String  deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee=employeeservice.findById(employeeId);
        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found"+employeeId);
        }
        employeeservice.deleteById(employeeId);
        return "deleted employee-ID"+employeeId;
    }
}

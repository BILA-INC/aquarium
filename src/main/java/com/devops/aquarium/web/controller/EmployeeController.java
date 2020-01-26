package com.devops.aquarium.web.controller;

import com.devops.aquarium.dao.EmployeeDao;
import com.devops.aquarium.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value="/Employees", method=RequestMethod.GET)
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    @GetMapping(value = "/Employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeDao.findEmployeeById(id);
    }
}
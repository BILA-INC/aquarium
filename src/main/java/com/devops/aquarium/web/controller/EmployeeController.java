package com.devops.aquarium.web.controller;

import com.devops.aquarium.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @RequestMapping(value="/Employees", method= RequestMethod.GET)
    public String employeesList() {
        return "Employees List";
    }

    @GetMapping("/Employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        Employee employee=new Employee(1, new String("Johnson"), new String("Downing Street"));
        return employee;
    }
}
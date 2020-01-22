package com.devops.aquarium.web.controller;

import com.devops.aquarium.dao.EmployeeDao;
import com.devops.aquarium.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value="/Employees", method=RequestMethod.GET)
    public List<Employee> employeesList() {
        return employeeDao.findAll();
    }

    @GetMapping(value="/Employees/{id}")
    public Employee getById(@PathVariable int id) {
        return employeeDao.findById(id);
    }

    @PostMapping(value = "/Employees")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {

        Employee employeeAdded =  employeeDao.save(employee);

        if (employeeAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employeeAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
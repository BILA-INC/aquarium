package com.devops.aquarium.web.controller;

import com.devops.aquarium.dao.EmployeeDao;
import com.devops.aquarium.model.Employee;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value="/Employees", method=RequestMethod.GET)
    public MappingJacksonValue employeesList() {
        Iterable<Employee> employees = employeeDao.findAll();

        SimpleBeanPropertyFilter sorter = SimpleBeanPropertyFilter.serializeAllExcept("numSS");

        FilterProvider sortersList = new SimpleFilterProvider().addFilter("dynamicSorter", sorter);

        MappingJacksonValue employeesSorters = new MappingJacksonValue(employees);

        employeesSorters.setFilters(sortersList);

        return employeesSorters;
    }

    /*
    @GetMapping(value="/Employees/{id}")
    public Employee getById(@PathVariable int id) {
        return employeeDao.findById(id);
    }

    @PostMapping(value = "/Employees")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {

        Employee employeeAdded =  employeeDao.save(employee);

        //Sending a 204 signal in case of failure
        if (employeeAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employeeAdded.getId())
                .toUri();
        //Sending the standard 201 signal code in case of success
        return ResponseEntity.created(location).build();
    }*/
}
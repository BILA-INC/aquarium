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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value="/Employees", method=RequestMethod.GET)
    public MappingJacksonValue findAllEmployees() {
        //return employeeDao.findAllEmployees();

        Iterable<Employee> employee= employeeDao.findAllEmployees();

        SimpleBeanPropertyFilter sorter = SimpleBeanPropertyFilter.serializeAllExcept("numSS");

        FilterProvider sorterId = new SimpleFilterProvider().addFilter("Sorter", sorter);

        MappingJacksonValue emp = new MappingJacksonValue(employee);

        emp.setFilters(sorterId);

        return emp;
    }

    @GetMapping(value = "/Employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeDao.findEmployeeById(id);
    }

    //Adding a new Employee
    @PostMapping(value = "/Employees")
    public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {

        Employee employeeAdded =  employeeDao.saveEmployee(employee);

        if (employeeAdded == null)
            return ResponseEntity.noContent().build(); //204 No Content in case of failure

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employeeAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

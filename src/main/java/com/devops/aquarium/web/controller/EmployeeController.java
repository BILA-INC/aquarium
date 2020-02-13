package com.devops.aquarium.web.controller;

import com.devops.aquarium.dao.EmployeeDao;
import com.devops.aquarium.model.Employee;
import com.devops.aquarium.web.exceptions.IdNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Api( description="API for, inter allia, CRUD-related operations on employees.")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value="/all/employee", method=RequestMethod.GET)
    public MappingJacksonValue findAllEmployees() {

        Iterable<Employee> employee= employeeDao.findAll();
        //SimpleBeanPropertyFilter sorter = SimpleBeanPropertyFilter.serializeAllExcept("numSS");
        //FilterProvider sorterId = new SimpleFilterProvider().addFilter("Sorter", sorter);
        MappingJacksonValue emp = new MappingJacksonValue(employee);
        //emp.setFilters(sorterId);
        return emp;
    }

    @ApiOperation(value = "Send back a given employee as far as the provided Id is correct")
    @GetMapping(value = "/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        Employee employee=employeeDao.findById(id);
        if(employee==null) throw new IdNotFoundException("Wrong Id"); //Customized exception throwing
        return employee;
    }

    @GetMapping(value = "/employees/GT/{id}")
    public List<Employee> findByIdGT(@PathVariable int id) {
        return employeeDao.findByIdGreaterThan(id);
    }

    /*@GetMapping(value = "/employees/research/{search}")
    public List<Employee> findByFirstNameLike(@PathVariable String search) {
        return employeeDao.findByFirstNameLike("%"+search+"%");
    }*/

    //Adding a new Employee
    @PostMapping(value = "add/employee",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
              return employeeDao.save(employee);
        /*Employee employeeAdded =  employeeDao.save(employee);

        if (employeeAdded == null)
            return ResponseEntity.noContent().build(); //204 No Content in case of failure

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employeeAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();*/
    }

    @DeleteMapping (value = "/employees/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeDao.deleteById(id);
    }
    @PutMapping (value = "/update/employee")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeDao.save(employee);
    }
}

package com.devops.aquarium.dao;

import com.devops.aquarium.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee employee);
}

package com.devops.aquarium.dao;

import com.devops.aquarium.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    //public List<Employee> findAllEmployees();
    //public Employee findEmployeeById(int id);
    //public Employee saveEmployee(Employee employee);

    Employee findById(int id);

    List<Employee> findByIdGreaterThan(int id);

    List<Employee> findByNameLike(String s);

}

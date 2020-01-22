package com.devops.aquarium.dao;

import com.devops.aquarium.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    public static List<Employee> employees= new ArrayList<>();
    //Simulating a Data Base, for a while
    static {
        employees.add(new Employee(1, new String("De Lesseps"), "SUEZ", 2335));
        employees.add(new Employee(2, new String("Eshkol"), "Holy Land", 887));
        employees.add(new Employee(3, new String("Gandalf"), "Mordore", 6755));
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(int id) {
        for (Employee employee : employees) {
            if(employee.getId() ==id){
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        employees.add(employee);
        return employee;
    }
}

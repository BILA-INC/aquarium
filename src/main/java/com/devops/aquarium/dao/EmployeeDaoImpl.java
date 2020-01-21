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
        employees.add(new Employee(1, new String("De Lesseps"), "SUEZ"));
        employees.add(new Employee(2, new String("Eshkol"), "Holy Land"));
        employees.add(new Employee(3, new String("Gandalf"), "Mordore"));
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
    public Employee Save(Employee employee) {
        employees.add(employee);
        return employee;
    }
}

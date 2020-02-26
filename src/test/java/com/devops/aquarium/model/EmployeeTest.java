package com.devops.aquarium.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
public class EmployeeTest {

    @Test
    public void testCanSetId(){
        Employee employee = new Employee();
        employee.setId(1);
        assertEquals(1, employee.getId());
        employee.setId(2);
        assertEquals(2, employee.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCannotSetIdIfNotDigit(){
        Employee employee = new Employee();
        employee.setId(11);
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetIdIfNull(){
        Employee employee = new Employee();
        employee.setId(0);
    }

    @Test
    public void testCanSetName(){
        Employee employee = new Employee();
        employee.setName("000000000000000");
        assertEquals("000000000000000", employee.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetNameIfNull(){
        Employee employee = new Employee();
        employee.setName(null);
    }

    @Test
    public void testCanSetFirstName(){
        Employee employee = new Employee();
        employee.setFirstName("HH");
        assertEquals("HH", employee.getFirstName());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetFirstNameIfNull(){
        Employee employee = new Employee();
        employee.setFirstName(null);
    }

    @Test
    public void testCanSetStartingHour(){
        Employee employee = new Employee();
        employee.setLastName("HHH");
        assertEquals("HHH", employee.getLastName());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetStartingHourIfNull(){
        Employee employee = new Employee();
        employee.setLastName(null);
    }
}


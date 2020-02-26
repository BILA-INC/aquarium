package com.devops.aquarium.dao;

import com.devops.aquarium.AquariumApplication;
import com.devops.aquarium.AquariumApplicationTests;
import com.devops.aquarium.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@Transactional
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestEntityManager
public class EmployeeDaoTest extends AquariumApplicationTests {

    @Autowired
    EmployeeDao employeeDao;

    @Before
    public void setUp(){}

    @Test
    public void testFindById(){
        Employee employee = new Employee();
        employee.setId(2);
        employeeDao.save(employee);
        assertEquals(employee, employeeDao.findById(2));
    }

    @Test
    public void testFindByName(){
        Employee employee = new Employee(); employee.setName("Test");
        employeeDao.save(employee);
        assertEquals(employee, employeeDao.findByName("Test"));
    }

    @Test
    public void testSave(){
        Employee employee = new Employee();
        employee.setName("Name");
        employeeDao.save(employee);
        assertEquals(employee, employeeDao.findByName("Name"));
    }

    @Test
    public void testUpdate(){
        Employee employee = employeeDao.findById(1);
        employee.setName("Test");
        employeeDao.update(employee);
        assertEquals(employee, employeeDao.findByName("Test"));
    }

    @Test
    public void testDelete(){
        Employee employee = new Employee(); employee.setName("Test");
        assertNotNull(employeeDao.save(employee));
        employeeDao.delete(employee);
        assertNull(employeeDao.findByName("Test"));
    }

}

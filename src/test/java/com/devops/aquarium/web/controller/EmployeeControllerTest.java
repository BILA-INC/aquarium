package com.devops.aquarium.web.controller;

import com.devops.aquarium.AquariumApplication;
import com.devops.aquarium.AquariumApplicationTests;
import com.devops.aquarium.model.Employee;
import com.devops.aquarium.web.controller.EmployeeController;
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
public class EmployeeControllerTest extends AquariumApplicationTests {

    @Autowired
    EmployeeController activityController;

    @Before
    public void setUp(){}

    @Test
    public void testFindById(){
        Employee activity = new Employee();
        activity.setId(2);
        activityController.saveEmployee(activity);
        assertEquals(activity, activityController.findEmployeeById(2));
    }

    @Test
    public void testFindByName(){
        Employee activity = new Employee(); activity.setId(1);
        activityController.saveEmployee(activity);
        assertEquals(activity, activityController.findEmployeeById(1));
    }

    @Test
    public void testSave(){
        Employee activity = new Employee();
        activity.setId(1);
        activityController.saveEmployee(activity);
        assertEquals(activity, activityController.findEmployeeById(1));
    }

    @Test
    public void testUpdate(){
        Employee activity = activityController.findEmployeeById(1);
        activity.setId(2);
        activityController.updateEmployee(activity);
        assertEquals(activity, activityController.findEmployeeById(2));
    }

    @Test
    public void testDelete(){
        Employee activity = new Employee(); activity.setId(2);
        assertNotNull(activityController.saveEmployee(activity));
        activityController.deleteEmployee(2);
        assertNull(activityController.findEmployeeById(2));
    }

}
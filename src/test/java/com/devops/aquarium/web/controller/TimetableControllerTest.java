package com.devops.aquarium.web.controller;

import com.devops.aquarium.AquariumApplication;
import com.devops.aquarium.AquariumApplicationTests;
import com.devops.aquarium.model.Timetable;
import com.devops.aquarium.web.controller.TimetableController;
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
public class TimetableControllerTest extends AquariumApplicationTests {

    @Autowired
    TimetableController timetableController;

    @Before
    public void setUp(){}

    @Test
    public void testFindById(){
        Timetable timetable = new Timetable();
        timetable.setId(2);
        timetableController.saveTimetable(timetable);
        assertEquals(timetable, timetableController.findTimetableById(2));
    }

    @Test
    public void testFindByName(){
        Timetable timetable = new Timetable(); timetable.setId(1);
        timetableController.saveTimetable(timetable);
        assertEquals(timetable, timetableController.findTimetableById(1));
    }

    @Test
    public void testSave(){
        Timetable timetable = new Timetable();
        timetable.setId(1);
        timetableController.saveTimetable(timetable);
        assertEquals(timetable, timetableController.findTimetableById(1));
    }

    @Test
    public void testUpdate(){
        Timetable timetable = timetableController.findTimetableById(1);
        timetable.setId(2);
        timetableController.updateTimetable(timetable);
        assertEquals(timetable, timetableController.findTimetableById(2));
    }

    @Test
    public void testDelete(){
        Timetable timetable = new Timetable(); timetable.setId(2);
        assertNotNull(timetableController.saveTimetable(timetable));
        timetableController.deleteTimetable(2);
        assertNull(timetableController.findTimetableById(2));
    }

}
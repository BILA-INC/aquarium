package com.devops.aquarium.dao;

import com.devops.aquarium.AquariumApplication;
import com.devops.aquarium.AquariumApplicationTests;
import com.devops.aquarium.model.Timetable;
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
public class TimetableDaoTest extends AquariumApplicationTests {

    @Autowired
    TimetableDao timetableDao;

    @Before
    public void setUp(){}

    @Test
    public void testFindById(){
        Timetable timetable = new Timetable();
        timetable.setId(2);
        timetableDao.save(timetable);
        assertEquals(timetable, timetableDao.findById(2));
    }

    @Test
    public void testFindByName(){
        Timetable timetable = new Timetable(); timetable.setName("Test");
        timetableDao.save(timetable);
        //assertEquals(timetable, timetableDao.findByName("Test"));
    }

    @Test
    public void testSave(){
        Timetable timetable = new Timetable();
        timetable.setName("Name");
        timetableDao.save(timetable);
        //assertEquals(timetable, timetableDao.findByName("Name"));
    }

    @Test
    public void testUpdate(){
        Timetable timetable = timetableDao.findById(1);
        timetable.setName("Test");
        //timetableDao.update(timetable);
        //assertEquals(timetable, timetableDao.findByName("Test"));
    }

    @Test
    public void testDelete(){
        Timetable timetable = new Timetable(); timetable.setName("Test");
        assertNotNull(timetableDao.save(timetable));
        timetableDao.delete(timetable);
        //assertNull(timetableDao.findByName("Test"));
    }

}

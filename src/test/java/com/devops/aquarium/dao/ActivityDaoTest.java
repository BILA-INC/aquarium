package com.devops.aquarium.dao;

import com.devops.aquarium.AquariumApplication;
import com.devops.aquarium.AquariumApplicationTests;
import com.devops.aquarium.model.Activity;
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
public class ActivityDaoTest extends AquariumApplicationTests {

    @Autowired
    ActivityDao activityDao;

    @Before
    public void setUp(){}

    @Test
    public void testFindById(){
        Activity activity = new Activity();
        activity.setId(2);
        activityDao.save(activity);
        assertEquals(activity, activityDao.findById(2));
    }

    @Test
    public void testFindByName(){
        Activity activity = new Activity(); activity.setName("Test");
        activityDao.save(activity);
        //assertEquals(activity, activityDao.findByName("Test"));
    }

    @Test
    public void testSave(){
        Activity activity = new Activity();
        activity.setName("Name");
        activityDao.save(activity);
        //assertEquals(activity, activityDao.findByName("Name"));
    }

    @Test
    public void testUpdate(){
        Activity activity = activityDao.findById(1);
        activity.setName("Test");
        activityDao.save(activity);
        //assertEquals(activity, activityDao.findByName("Test"));
    }

    @Test
    public void testDelete(){
        Activity activity = new Activity(); activity.setName("Test");
        assertNotNull(activityDao.save(activity));
        activityDao.delete(activity);
        //assertNull(activityDao.findByName("Test"));
    }

}

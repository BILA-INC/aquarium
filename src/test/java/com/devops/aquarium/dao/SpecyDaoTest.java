package com.devops.aquarium.dao;

import com.devops.aquarium.AquariumApplication;
import com.devops.aquarium.AquariumApplicationTests;
import com.devops.aquarium.model.Specy;
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
public class SpecyDaoTest extends AquariumApplicationTests {

    @Autowired
    SpecyDao specyDao;

    @Before
    public void setUp(){}

    @Test
    public void testFindById(){
        Specy specy = new Specy();
        specy.setId(2);
        specyDao.save(specy);
        assertEquals(specy, specyDao.findById(2));
    }

    @Test
    public void testFindByName(){
        Specy specy = new Specy(); specy.setName("Test");
        specyDao.save(specy);
        //assertEquals(specy, specyDao.findByName("Test"));
    }

    @Test
    public void testSave(){
        Specy specy = new Specy();
        specy.setName("Name");
        specyDao.save(specy);
        //assertEquals(specy, specyDao.findByName("Name"));
    }

    @Test
    public void testUpdate(){
        Specy specy = specyDao.findById(1);
        specy.setName("Test");
        //specyDao.update(specy);
        //assertEquals(specy, specyDao.findByName("Test"));
    }

    @Test
    public void testDelete(){
        Specy specy = new Specy(); specy.setName("Test");
        assertNotNull(specyDao.save(specy));
        specyDao.delete(specy);
        //assertNull(specyDao.findByName("Test"));
    }

}

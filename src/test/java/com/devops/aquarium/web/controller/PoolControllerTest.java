package com.devops.aquarium.web.controller;

import com.devops.aquarium.AquariumApplication;
import com.devops.aquarium.AquariumApplicationTests;
import com.devops.aquarium.model.Pool;
import com.devops.aquarium.web.controller.PoolController;
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
public class PoolControllerTest extends AquariumApplicationTests {

    @Autowired
    PoolController poolController;

    @Before
    public void setUp(){}

    @Test
    public void testFindById(){
        Pool pool = new Pool();
        pool.setId(2);
        poolController.savePool(pool);
        assertEquals(pool, poolController.findPoolById(2));
    }

    @Test
    public void testFindByName(){
        Pool pool = new Pool(); pool.setId(1);
        poolController.savePool(pool);
        assertEquals(pool, poolController.findPoolById(1));
    }

    @Test
    public void testSave(){
        Pool pool = new Pool();
        pool.setId(1);
        poolController.savePool(pool);
        assertEquals(pool, poolController.findPoolById(1));
    }

    @Test
    public void testUpdate(){
        Pool pool = poolController.findPoolById(1);
        pool.setId(2);
        poolController.updatePool(pool);
        assertEquals(pool, poolController.findPoolById(2));
    }

    @Test
    public void testDelete(){
        Pool pool = new Pool(); pool.setId(2);
        assertNotNull(poolController.savePool(pool));
        poolController.deletePool(2);
        assertNull(poolController.findPoolById(2));
    }

}
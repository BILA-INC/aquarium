package com.devops.aquarium.dao;

import com.devops.aquarium.AquariumApplication;
import com.devops.aquarium.AquariumApplicationTests;
import com.devops.aquarium.model.Pool;
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
public class PoolDaoTest extends AquariumApplicationTests {

    @Autowired
    PoolDao poolDao;

    @Before
    public void setUp(){}

    @Test
    public void testFindById(){
        Pool pool = new Pool();
        pool.setId(2);
        poolDao.save(pool);
        assertEquals(pool, poolDao.findById(2));
    }

    @Test
    public void testFindByName(){
        Pool pool = new Pool(); pool.setName("Test");
        poolDao.save(pool);
        assertEquals(pool, poolDao.findByName("Test"));
    }

    @Test
    public void testSave(){
        Pool pool = new Pool();
        pool.setName("Name");
        poolDao.save(pool);
        assertEquals(pool, poolDao.findByName("Name"));
    }

    @Test
    public void testUpdate(){
        Pool pool = poolDao.findById(1);
        pool.setName("Test");
        poolDao.update(pool);
        assertEquals(pool, poolDao.findByName("Test"));
    }

    @Test
    public void testDelete(){
        Pool pool = new Pool(); pool.setName("Test");
        assertNotNull(poolDao.save(pool));
        poolDao.delete(pool);
        assertNull(poolDao.findByName("Test"));
    }

}


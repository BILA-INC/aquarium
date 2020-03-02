package com.devops.aquarium.dao;

import com.devops.aquarium.AquariumApplication;
import com.devops.aquarium.AquariumApplicationTests;
import com.devops.aquarium.model.Animal;
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
public class AnimalDaoTest extends AquariumApplicationTests {

    @Autowired
    AnimalDao animalDao;

    @Before
    public void setUp(){}

    @Test
    public void testFindById(){
        Animal animal = new Animal();
        animal.setId(2);
        animalDao.save(animal);
        assertEquals(animal, animalDao.findById(2));
    }

    @Test
    public void testFindByName(){
        Animal animal = new Animal(); animal.setName("Test");
        animalDao.save(animal);
        //assertEquals(animal, animalDao.findByName("Test"));
    }

    @Test
    public void testSave(){
        Animal animal = new Animal();
        animal.setName("Name");
        animalDao.save(animal);
        //assertEquals(animal, animalDao.findByName("Name"));
    }

    @Test
    public void testUpdate(){
        Animal animal = animalDao.findById(1);
        animal.setName("Test");
        //animalDao.update(animal);
        //assertEquals(animal, animalDao.findByName("Test"));
    }

    @Test
    public void testDelete(){
        Animal animal = new Animal(); animal.setName("Test");
        assertNotNull(animalDao.save(animal));
        animalDao.delete(animal);
        //assertNull(animalDao.findByName("Test"));
    }

}

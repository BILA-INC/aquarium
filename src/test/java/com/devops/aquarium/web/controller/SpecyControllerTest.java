package com.devops.aquarium.web.controller;

import com.devops.aquarium.AquariumApplication;
import com.devops.aquarium.AquariumApplicationTests;
import com.devops.aquarium.model.Specy;
import com.devops.aquarium.web.controller.SpecyController;
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
public class SpecyControllerTest extends AquariumApplicationTests {

    @Autowired
    SpecyController specyController;

    @Before
    public void setUp(){}

    @Test
    public void testFindById(){
        Specy specy = new Specy();
        specy.setId(2);
        specyController.saveSpecy(specy);
        assertEquals(specy, specyController.findSpecyById(2));
    }

    @Test
    public void testFindByName(){
        Specy specy = new Specy(); specy.setId(1);
        specyController.saveSpecy(specy);
        assertEquals(specy, specyController.findSpecyById(1));
    }

    @Test
    public void testSave(){
        Specy specy = new Specy();
        specy.setId(1);
        specyController.saveSpecy(specy);
        assertEquals(specy, specyController.findSpecyById(1));
    }

    @Test
    public void testUpdate(){
        Specy specy = specyController.findSpecyById(1);
        specy.setId(2);
        specyController.updateSpecy(specy);
        assertEquals(specy, specyController.findSpecyById(2));
    }

    @Test
    public void testDelete(){
        Specy specy = new Specy(); specy.setId(2);
        assertNotNull(specyController.saveSpecy(specy));
        specyController.deleteSpecy(2);
        assertNull(specyController.findSpecyById(2));
    }

}
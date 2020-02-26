package com.devops.aquarium.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
public class SpecyTest {

    @Test
    public void testCanSetId(){
        Specy activity = new Specy();
        activity.setId(1);
        assertEquals(1, activity.getId());
        activity.setId(2);
        assertEquals(2, activity.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCannotSetIdIfNotDigit(){
        Specy activity = new Specy();
        activity.setId(11);
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetIdIfNull(){
        Specy activity = new Specy();
        activity.setId(0);
    }

    @Test
    public void testCanSetName(){
        Specy activity = new Specy();
        activity.setName("000000000000000");
        assertEquals("000000000000000", activity.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetNameIfNull(){
        Specy activity = new Specy();
        activity.setName(null);
    }

    @Test
    public void testCanSetDiet(){
        Specy activity = new Specy();
        activity.setDiet("UI");
        assertEquals("UI", activity.getDiet());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetDietIfNull(){
        Specy activity = new Specy();
        activity.setDiet(null);
    }

    @Test
    public void testCanSetDangerLevel(){
        Specy activity = new Specy();
        activity.setDangerLevel("10");
        assertEquals("10", activity.getDangerLevel());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetDangerLevelIfNull(){
        Specy activity = new Specy();
        activity.setDangerLevel(null);
    }

}


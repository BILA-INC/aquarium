package com.devops.aquarium.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
public class ActivityTest {

    @Test
    public void testCanSetId(){
        Activity activity = new Activity();
        activity.setId(1);
        assertEquals(1, activity.getId());
        activity.setId(2);
        assertEquals(2, activity.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCannotSetIdIfNotDigit(){
        Activity activity = new Activity();
        activity.setId(11);
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetIdIfNull(){
        Activity activity = new Activity();
        activity.setId(0);
    }

    @Test
    public void testCanSetName(){
        Activity activity = new Activity();
        activity.setName("000000000000000");
        assertEquals("000000000000000", activity.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetNameIfNull(){
        Activity activity = new Activity();
        activity.setName(null);
    }

    @Test
    public void testCanSetDay(){
        Activity activity = new Activity();
        activity.setDay("Monday");
        assertEquals("Monday", activity.getDay());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetDayIfNull(){
        Activity activity = new Activity();
        activity.setDay(null);
    }

    @Test
    public void testCanSetStartingHour(){
        Activity activity = new Activity();
        activity.setStartingHour("11:00");
        assertEquals("11:00", activity.getStartingHour());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetStartingHourIfNull(){
        Activity activity = new Activity();
        activity.setStartingHour(null);
    }

    public void testCanChangePublicPrivate() {
        Activity activity = new Activity();
        activity.setPublicPrivateB(false);
        assertFalse(activity.getPublicPrivateB());
    }
}


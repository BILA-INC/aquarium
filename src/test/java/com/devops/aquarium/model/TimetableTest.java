package com.devops.aquarium.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
public class TimetableTest {

    @Test
    public void testCanSetId(){
        Timetable timetable = new Timetable();
        timetable.setId(1);
        assertEquals(1, timetable.getId());
        timetable.setId(2);
        assertEquals(2, timetable.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCannotSetIdIfNotDigit(){
        Timetable timetable = new Timetable();
        timetable.setId(11);
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetIdIfNull(){
        Timetable timetable = new Timetable();
        timetable.setId(0);
    }

    @Test
    public void testCanSetName(){
        Timetable timetable = new Timetable();
        timetable.setName("000000000000000");
        assertEquals("000000000000000", timetable.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetNameIfNull(){
        Timetable timetable = new Timetable();
        timetable.setName(null);
    }

    @Test
    public void testCanSetStartingHour(){
        Timetable timetable = new Timetable();
        timetable.setStartingHour("11:09");
        assertEquals("11:09", timetable.getStartingHour());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetStartingHourIfNull(){
        Timetable timetable = new Timetable();
        timetable.setStartingHour(null);
    }

    @Test
    public void testCanSetDangerLevel(){
        Timetable timetable = new Timetable();
        timetable.setEndingHour("11:00");
        assertEquals("11:00", timetable.getEndingHour());
    }


}


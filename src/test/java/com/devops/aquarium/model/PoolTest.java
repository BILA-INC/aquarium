package com.devops.aquarium.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
public class PoolTest {

    @Test
    public void testCanSetId(){
        Pool activity = new Pool();
        activity.setId(1);
        assertEquals(1, activity.getId());
        activity.setId(2);
        assertEquals(2, activity.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCannotSetIdIfNotDigit(){
        Pool activity = new Pool();
        activity.setId(11);
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetIdIfNull(){
        Pool activity = new Pool();
        activity.setId(0);
    }

    @Test
    public void testCanSetName(){
        Pool activity = new Pool();
        activity.setName("000000000000000");
        assertEquals("000000000000000", activity.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetNameIfNull(){
        Pool activity = new Pool();
        activity.setName(null);
    }

    @Test
    public void testCanSetIsClean(){
        Pool activity = new Pool();
        activity.setIsClean("PP");
        assertEquals("PP", activity.getIsClean());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetIsCleanIfNull(){
        Pool activity = new Pool();
        activity.setIsClean(null);
    }

    @Test
    public void testCanSetActivity(){
        Pool activity = new Pool();
        activity.setActivity("BB");
        assertEquals("BB", activity.getActivity());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetActivityIfNull(){
        Pool activity = new Pool();
        activity.setActivity(null);
    }
}


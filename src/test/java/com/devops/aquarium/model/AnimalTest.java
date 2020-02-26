package com.devops.aquarium.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
public class AnimalTest {

    @Test
    public void testCanSetId(){
        Animal animal = new Animal();
        animal.setId(1);
        assertEquals(1, animal.getId());
        animal.setId(2);
        assertEquals(2, animal.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCannotSetIdIfNotDigit(){
        Animal animal = new Animal();
        animal.setId(11);
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetIdIfNull(){
        Animal animal = new Animal();
        animal.setId(0);
    }

    @Test
    public void testCanSetName(){
        Animal animal = new Animal();
        animal.setName("000000000000000");
        assertEquals("000000000000000", animal.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetNameIfNull(){
        Animal animal = new Animal();
        animal.setName(null);
    }

    @Test
    public void testCanSetSpecy(){
        Animal animal = new Animal();
        animal.setSpecy("FG");
        assertEquals("FG", animal.getSpecy());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetSpecyIfNull(){
        Animal animal = new Animal();
        animal.setSpecy(null);
    }

    @Test
    public void testCanSetArrivalDate(){
        Animal animal = new Animal();
        //animal.setArrivalDate("11-00-11");
        assertEquals("11:00", animal.getArrivalDate());
    }

    @Test(expected = NullPointerException.class)
    public void testCannotSetArrivalDateIfNull(){
        Animal animal = new Animal();
        animal.setArrivalDate(null);
    }

}


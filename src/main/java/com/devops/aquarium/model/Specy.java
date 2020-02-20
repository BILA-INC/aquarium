package com.devops.aquarium.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

//@JsonIgnoreProperties(value = {"attribute"}) //Listing attributes to not send in the JSON file
@Entity
public class Specy {

    @Id
    //@GeneratedValue
    //@Min(value = 1)
    private int id;
    //@Length(min=1, max=40)
    private String name;
    private String diet;
    private int lifeExpectancy;
    private boolean isEndangered;

    public int getId() {return this.id;
    }
}

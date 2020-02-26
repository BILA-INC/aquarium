package com.devops.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//@JsonIgnoreProperties(value = {"attribute"}) //Listing attributes to not send in the JSON file
@Entity
public class Specy {

    //@GeneratedValue
    //@Min(value = 1)
    @Id
    private int id;
    //@Length(min=1, max=40)
    private String name; private String diet;
    private int lifeExpectancy; private String isEndangered; private String dangerLevel;

    public Specy() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getIsEndangered() {
        return isEndangered;
    }

    public void setIsEndangered(String isEndangered) {
        this.isEndangered = isEndangered;
    }

    public String getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    //void update(Specy specy)  {}

    @Override
    public String toString() {
        return "Specy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", diet='" + diet + '\'' +
                ", lifeExpectancy=" + lifeExpectancy +
                ", isEndangered=" + isEndangered +
                ", dangerLevel=" + dangerLevel +
                '}';
    }
}

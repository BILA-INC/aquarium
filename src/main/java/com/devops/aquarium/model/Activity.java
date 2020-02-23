package com.devops.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Activity {

    private @Id int id;
    private String day; private String startingHour; private String endingHour; private String publicPrivate; private String name;

    public Activity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() { return day; }

    public void setDay(String day) { this.day = day; }

    public String getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(String startingHour) {
        this.startingHour = startingHour;
    }

    public String getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(String endingHour) {
        this.endingHour = endingHour;
    }

    public String getPublicPrivate() {
        return publicPrivate;
    }

    public void setPublicPrivate(String publicPrivate) {
        this.publicPrivate = publicPrivate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", day='" + day + '\'' +
                ", startingHour='" + startingHour + '\'' +
                ", endingHour='" + endingHour + '\'' +
                ", publicPrivate='" + publicPrivate + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

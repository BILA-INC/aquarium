package com.devops.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Timetable {

    @Id private int id;
    private String day; private String activity; private String startingHour; private String endingHour;

    public Timetable() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

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

    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", day='" + day + '\'' +
                ", activity='" + activity + '\'' +
                ", startingHour='" + startingHour + '\'' +
                ", endingHour='" + endingHour + '\'' +
                '}';
    }
}

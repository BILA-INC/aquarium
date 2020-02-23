package com.devops.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Timetable {

    @Id private int id;
    private String day; private String activity; private String startingHour; private String endingHour;
}

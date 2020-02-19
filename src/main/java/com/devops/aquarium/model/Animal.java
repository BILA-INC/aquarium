package com.devops.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Animal {

    @Id int id; String name; String specy; String sign; Date arrivalDate; Date departureDate;
}

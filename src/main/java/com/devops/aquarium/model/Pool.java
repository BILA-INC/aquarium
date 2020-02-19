package com.devops.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pool {

    @Id
    int id;
    int maxPopulation;
    int maxVolume;
    boolean isClean;
}

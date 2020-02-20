package com.devops.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pool {

    @Id
    private int id;
    private int maxPopulation; private int maxVolume;
    private boolean isClean; private String zoneName; String zoneLocalisation;

    public Pool() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public void setMaxPopulation(int maxPopulation) {
        this.maxPopulation = maxPopulation;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getZoneLocalisation() {
        return zoneLocalisation;
    }

    public void setZoneLocalisation(String zoneLocalisation) {
        this.zoneLocalisation = zoneLocalisation;
    }

    @Override
    public String toString() {
        return "Pool{" +
                "id=" + id +
                ", maxPopulation=" + maxPopulation +
                ", maxVolume=" + maxVolume +
                ", isClean=" + isClean +
                ", zoneName='" + zoneName + '\'' +
                ", zoneLocalisation='" + zoneLocalisation + '\'' +
                '}';
    }
}

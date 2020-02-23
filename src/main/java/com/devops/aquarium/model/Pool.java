package com.devops.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pool {

    @Id
    private int id; private String name;
    private int maxPopulation; private int maxVolume;
    private String isClean; private String zoneName; String zoneLocalisation; String activity;

    public Pool() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

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

    public String getIsClean() {
        return isClean;
    }

    public void setIsClean(String isClean) {
        this.isClean = isClean;
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

    public String getActivity() { return activity; }

    public void setActivity(String activity) { this.activity = activity; }

    @Override
    public String toString() {
        return "Pool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxPopulation=" + maxPopulation +
                ", maxVolume=" + maxVolume +
                ", isClean='" + isClean + '\'' +
                ", zoneName='" + zoneName + '\'' +
                ", zoneLocalisation='" + zoneLocalisation + '\'' +
                ", activity='" + activity + '\'' +
                '}';
    }
}

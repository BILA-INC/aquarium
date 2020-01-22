package com.devops.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"numSS"})
public class Employee {

    private int id;
    private String name;
    private String address;
    private int numSS;

    public Employee() {
    }

    public Employee(int id, String name, String address, int numSS) {
        this.id=id; this.name=name; this.address=address; this.numSS=numSS;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public int getNumSS() { return numSS; }

    public void setNumSS(int numSS) { this.numSS = numSS; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}

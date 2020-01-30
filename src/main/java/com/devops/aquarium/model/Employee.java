package com.devops.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

//@JsonIgnoreProperties(value = {"numSS"}) //Listing attributes to not send in the JSON file
@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Min(value = 1)
    private int id;

    @Length(min=1, max=40)
    private String name;
    @Length(min=3, max=40)
    private String address;
    //Privacy-related attributes
    @Length(min=13, max=15, message="Wrong Numéro de Sécu")
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

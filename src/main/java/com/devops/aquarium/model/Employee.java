package com.devops.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//@JsonIgnoreProperties(value = {"numSS"}) //Listing attributes to not send in the JSON file
@Entity
public class Employee {

    @Id
    //@GeneratedValue
    //@Min(value = 1)
    private int id;

    //@Length(min=1, max=40)
    private String firstName;
    //@Length(min=3, max=40)
    private String lastName;
    //Privacy-related attributes
    //@Length(min=1, max=5, message="Wrong Numéro de Sécu")
    private String address;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String address) {
        this.id=id; this.firstName=firstName; this.lastName=lastName; this.address=address;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() { return this.address; }

    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", full name='" + firstName + lastName+ '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}

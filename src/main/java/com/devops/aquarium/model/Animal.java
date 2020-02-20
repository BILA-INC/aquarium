package com.devops.aquarium.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Animal {

    private @Id int id; private String name; private String specy; private boolean sex;
    private String sign; private Date arrivalDate; private Date departureDate;

    public Animal() {}

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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getSpecy() {
        return specy;
    }

    public void setSpecy(String specy) {
        this.specy = specy;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specy='" + specy + '\'' +
                ", sex=" + sex +
                ", sign='" + sign + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                '}';
    }
}

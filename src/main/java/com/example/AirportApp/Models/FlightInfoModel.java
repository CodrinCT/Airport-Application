package com.example.AirportApp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class FlightInfoModel {

   private int id;
    private String planeClass;
    private int nrOfSits;
   private int availableSits;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaneClass() {
        return planeClass;
    }

    public void setPlaneClass(String planeClass) {
        this.planeClass = planeClass;
    }

    public Integer getNrOfSits() {
        return nrOfSits;
    }

    public void setNrOfSits(Integer nrOfSits) {
        this.nrOfSits = nrOfSits;
    }

    public Integer getAvailableSits() {
        return availableSits;
    }

    public void setAvailableSits(Integer availableSits) {
        this.availableSits = availableSits;
    }
}

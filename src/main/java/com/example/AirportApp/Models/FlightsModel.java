package com.example.AirportApp.Models;

import javax.persistence.*;
import java.util.Date;


public class FlightsModel{

    private int id;
    private String origin;
    private String destination;
    @Temporal(TemporalType.TIME)
    private Date timeUntilArrival;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfArrival;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfDeparture;

    public FlightsModel(){

    }

    public FlightsModel(int id, String origin, String destination, Date timeUntilArrival) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.timeUntilArrival = timeUntilArrival;
    }


    public Date getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(Date timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public Date getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(Date timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getTimeUntilArrival() {
        return timeUntilArrival;
    }

    public void setTimeUntilArrival(Date timeUntilArrival) {
        this.timeUntilArrival = timeUntilArrival;
    }
}

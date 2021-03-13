package com.example.AirportApp.Models;

public class PassengerModel {

    int passengerId;
    int ticketId;
    String passengerName;
    int passengerFlightId;

    public int getPassengerFlightId() {
        return passengerFlightId;
    }

    public void setPassengerFlightId(int passengerFlightId) {
        this.passengerFlightId = passengerFlightId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

}

package com.example.AirportApp.Models;


public class TicketModel {

    private int ticketId;
    private int flightId;
    private String price;
//    private String ticketClass;
//    private String sitNumber;
    private String passengerName;
    private int quantity;
    private int basePrice;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    private FlightsModel flight;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        price = String.valueOf(basePrice*quantity);
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setFlight(FlightsModel flight){
      this.flight = flight;
    }

    public FlightsModel getFlight() {
        return flight;
    }

    //    public String getTicketClass() {
//        return ticketClass;
//    }
//
//    public void setTicketClass(String ticketClass) {
//        this.ticketClass = ticketClass;
//    }
//
//    public String getSitNumber() {
//        return sitNumber;
//    }
//
//    public void setSitNumber(String sitNumber) {
//        this.sitNumber = sitNumber;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
}

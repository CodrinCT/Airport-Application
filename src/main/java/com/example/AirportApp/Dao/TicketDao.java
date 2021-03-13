package com.example.AirportApp.Dao;

import com.example.AirportApp.Models.TicketModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TicketDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private TicketModel getTicket(ResultSet resultSet, int rowNum) throws SQLException {
        TicketModel ticketModel = new TicketModel();
        ticketModel.setTicketId(resultSet.getInt("tickets_id"));
        ticketModel.setPrice(resultSet.getString("price"));
        ticketModel.setFlightId(resultSet.getInt("flight_id"));
        ticketModel.setPassengerName(resultSet.getString("passenger_name"));
        return ticketModel;
    }

    public TicketModel getTicketsByFlight(int flightId){
        return jdbcTemplate.queryForObject("SELECT * FROM tickets WHERE flight_id = ?",this::getTicket ,flightId);
    }

    public void cancelTicket(String user){
        jdbcTemplate.update("DELETE  FROM tickets WHERE passenger_name = ?",user);
    }

    public void makeTicket(int flightId, int price, String passengerName){
        jdbcTemplate.update("INSERT INTO tickets(flight_id, price, passenger_name) VALUES (?, ?, ?)", flightId, price,passengerName);
    }
    
    public TicketModel getTicketByTicketId(String passengerName){
       return jdbcTemplate.queryForObject("SELECT * FROM tickets WHERE passenger_name = ?", this::getTicket, passengerName);
    }
}

package com.example.AirportApp.Dao;

import com.example.AirportApp.Models.PassengerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PassengerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public PassengerModel getPassenger(ResultSet resultSet, int rowNum) throws SQLException {
        PassengerModel passengerModel = new PassengerModel();
        passengerModel.setPassengerId(resultSet.getInt("passengersId"));
        passengerModel.setPassengerName(resultSet.getString("passengerName"));
        passengerModel.setTicketId(resultSet.getInt("ticketId"));
        passengerModel.setPassengerFlightId(resultSet.getInt("passengerFlightId"));
        return passengerModel;
    }


    public List<PassengerModel> getAllPassengers(){
        return jdbcTemplate.query("SELECT * FROM passengers",this::getPassenger);
    }

    public List<PassengerModel> getPassengersByFlightId(int passengerFlightId){
        return jdbcTemplate.query("SELECT * FROM passengers WHERE passengerFlightId = ?", this::getPassenger, passengerFlightId);
    }

    public List<PassengerModel> getPassengersByTicketId(int ticketId){
        return jdbcTemplate.query("SELECT * FROM passengers WHERE ticketId = ? ", this::getPassenger, ticketId);
    }

    public PassengerModel getPassengerByPassengerId(int passengerId){
        return jdbcTemplate.queryForObject("SELECT * FROM passenger WHERE passengerId = ?", this::getPassenger, passengerId);
    }

    public void registerPassengerToFlight(String passengerName, int ticketId, int passengerFlightId){
        jdbcTemplate.update("INSERT INTO passengers(passengerName,ticketId,passengerFlightId) values(?,?,?)", passengerName, ticketId, passengerFlightId);
    }
    public void cancelPassenger(int ticketId){
        jdbcTemplate.update("DELETE * FROM passengers WHERE ticketId = ?", ticketId);
    }

    public Integer getNumberOfPassengers(){
        List<PassengerModel> passengerModelList;
        passengerModelList = jdbcTemplate.query("SELECT * FROM passengers",this::getPassenger);
        return passengerModelList.size();
    }
}

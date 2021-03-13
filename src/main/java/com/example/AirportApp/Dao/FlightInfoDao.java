package com.example.AirportApp.Dao;

import com.example.AirportApp.Models.FlightInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class FlightInfoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private FlightInfoModel getInfo (ResultSet resultSet, int rowNum) throws SQLException {
        FlightInfoModel flightsModel = new FlightInfoModel();
        flightsModel.setId(resultSet.getInt("idflight_personal_info"));
        flightsModel.setPlaneClass(resultSet.getString("class"));
        flightsModel.setNrOfSits(resultSet.getInt("number_of_sits"));
        flightsModel.setAvailableSits(resultSet.getInt("available_sits"));
        return flightsModel;
    }

    private Integer getNrSeats(ResultSet resultSet, int rowNum) throws SQLException {
        FlightInfoModel flightInfoModel = new FlightInfoModel();
        flightInfoModel.setNrOfSits(resultSet.getInt("number_of_sits"));
        return flightInfoModel.getNrOfSits();
    }
    private Integer getNrSeatsAvailable(ResultSet resultSet, int rowNum) throws SQLException {
        FlightInfoModel flightInfoModel = new FlightInfoModel();
        flightInfoModel.setAvailableSits(resultSet.getInt("available_sits"));
        return flightInfoModel.getNrOfSits();
    }

    public FlightInfoModel getFlightInfoById(int id){
        FlightInfoModel info;
        info = jdbcTemplate.queryForObject("SELECT * FROM flight_personal_info WHERE idflight_personal_info = ?", this::getInfo,id);
        return info;
    }

    public Integer getNumberOfSeatsById(int flightId){
        return jdbcTemplate.queryForObject("SELECT number_of_sits FROM flight_personal_info WHERE idflight_personal_info = ?",this::getNrSeats, flightId);
    }

    public Integer getNumberOfAvailableSeatsById(int flightId){
        return jdbcTemplate.queryForObject("SELECT available_sits FROM flight_personal_info WHERE idflight_personal_info = ?",this::getNrSeatsAvailable, flightId);
    }

    public void setNumberOfAvailableSeats(int nrOfPassengers,int originalNr){
         int seatsLeft = originalNr - nrOfPassengers;
        jdbcTemplate.update("update flight_personal_info set available_sits=? where number_of_sits=?", seatsLeft, originalNr);
    }


}

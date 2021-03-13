package com.example.AirportApp.Dao;

import com.example.AirportApp.Models.FlightInfoModel;
import com.example.AirportApp.Models.FlightsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FlightsDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<FlightsModel> showAllFlights(){
        return jdbcTemplate.query("SELECT * FROM flights",this::getFlight);

    }
    private FlightsModel getFlight (ResultSet resultSet, int rowNum) throws SQLException {
        FlightsModel flightsModel = new FlightsModel();
        flightsModel.setId(resultSet.getInt("id"));
        flightsModel.setOrigin(resultSet.getString("Origin"));
        flightsModel.setDestination(resultSet.getString("Destination"));
        flightsModel.setTimeUntilArrival(resultSet.getTime("time_until_arrival"));
        flightsModel.setTimeOfArrival(resultSet.getTime("time_of_arrival"));
        flightsModel.setTimeOfDeparture(resultSet.getTime("time_of_departure"));
        return flightsModel;
    }

    public List<FlightsModel> showFlightsByOriginAndDestination(String origin, String destination){
        return jdbcTemplate.query("SELECT * FROM flights WHERE Origin = ? AND Destination = ?", this::getFlight, origin,destination);
    }

    public List<FlightsModel> showFlightsByOrigin(String origin){
        return jdbcTemplate.query("SELECT * FROM flights WHERE Origin =?", this::getFlight, origin);
    }

    public List<FlightsModel> showFlightsByDestination(String destination){
        return jdbcTemplate.query("SELECT * FROM flights WHERE Destination =?", this::getFlight,destination);
    }




    public FlightsModel getFlightById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM flights WHERE id = ?", this::getFlight,id);
   }
}

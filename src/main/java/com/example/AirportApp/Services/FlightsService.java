package com.example.AirportApp.Services;

import com.example.AirportApp.Dao.FlightInfoDao;
import com.example.AirportApp.Dao.FlightsDao;
import com.example.AirportApp.Models.FlightInfoModel;
import com.example.AirportApp.Models.FlightsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class FlightsService {

    @Autowired
    FlightsDao flightsDao;

    @Autowired
    FlightInfoDao flightInfoDao;

//    int secondsPassed = 0;
//    Timer myTimer = new Timer();
//    TimerTask task = new TimerTask() {
//        @Override
//        public void run() {
//            secondsPassed++;
//        }
//    }
    public List<FlightsModel> getAllFlights(){

        return flightsDao.showAllFlights();
    }

    public FlightInfoModel getById( int id){
        return flightInfoDao.getFlightInfoById(id);
    }
    public List<FlightsModel> showFlightsByOriginAndDestination(String origin, String destination){
        return flightsDao.showFlightsByOriginAndDestination(origin,destination);
    }

    public List<FlightsModel> showFlightsByOrigin(String origin){
        return flightsDao.showFlightsByOrigin(origin);
    }

    public List<FlightsModel> showFlightsByDestination(String destination){
        return flightsDao.showFlightsByDestination(destination);
    }
}

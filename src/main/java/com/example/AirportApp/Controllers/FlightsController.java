package com.example.AirportApp.Controllers;
import com.example.AirportApp.Models.FlightsModel;
import com.example.AirportApp.Services.FlightsService;
import com.example.AirportApp.Services.PassengersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/flightslist")
public class FlightsController {

    @Autowired
    FlightsService flightsService;

    @Autowired
    PassengersService passengersService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayFlightsUser(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if (session.getAttribute("logged_user")!=null){
            modelAndView.setViewName("list-user-flights");
        }else if (session.getAttribute("admin")!=null){
            modelAndView.setViewName("list-admin-flights");
        }else{
            modelAndView.setViewName("redirect:/home");
        }
       // modelAndView.setViewName("list-user-flights");
        modelAndView.addObject("flights",flightsService.getAllFlights());
        return modelAndView;
    }

    @GetMapping("/information/{flightId}")
    public ModelAndView displayFlightInformation(@PathVariable("flightId") int flightId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plane-info-list");
        passengersService.changeNumberOfAvailableSeats(flightId);
        modelAndView.addObject("info", flightsService.getById(flightId));
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView displaySpecifiedFlights(FlightsModel flightsModel){
        ModelAndView modelAndView = new ModelAndView();
        if (!flightsModel.getOrigin().equals("")&& !flightsModel.getDestination().equals("")){
            modelAndView.setViewName("list-user-flights");
            modelAndView.addObject("flights" ,flightsService.showFlightsByOriginAndDestination(flightsModel.getOrigin(), flightsModel.getDestination()));
            System.out.println("both");
        }else if (!flightsModel.getOrigin().equals("") & flightsModel.getDestination().equals("")){
            modelAndView.setViewName("list-user-flights");
            modelAndView.addObject("flights" ,flightsService.showFlightsByOrigin(flightsModel.getOrigin()));
            System.out.println("origin");
        }else if (flightsModel.getOrigin().equals("") && !flightsModel.getDestination().equals("")){
            modelAndView.setViewName("list-user-flights");
            modelAndView.addObject("flights" ,flightsService.showFlightsByDestination(flightsModel.getDestination()));
            System.out.println("destination");
        }else {
            modelAndView.setViewName("list-user-flights");
        }

        return modelAndView;
    }
}

package com.example.AirportApp.Controllers;

import com.example.AirportApp.Services.PassengersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PassengersController {

    @Autowired
    PassengersService passengersService;

    @GetMapping("/passengers/{id}")
    public ModelAndView displayFlightPassengers(@PathVariable int id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("flight-passengers");
        mav.addObject("passenger", passengersService.getPassengersByFlightId(id));
        return mav;
    }
    @DeleteMapping("/cancel/{ticketId}")
    public ModelAndView cancelPassenger(@RequestParam("ticketId") int ticketId){
        ModelAndView mav = new ModelAndView();
        passengersService.cancelPassenger(ticketId);
        mav.setViewName("redirect:/{id}/passengers");
        return mav;
    }
}

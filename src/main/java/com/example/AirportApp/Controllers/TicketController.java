package com.example.AirportApp.Controllers;

import com.example.AirportApp.Dao.ClassDao;
import com.example.AirportApp.Dao.TicketDao;
import com.example.AirportApp.Models.ClassModel;
import com.example.AirportApp.Models.TicketModel;

import com.example.AirportApp.Services.PassengersService;
import com.example.AirportApp.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class TicketController {


    @Autowired
   TicketService ticketService;

    @Autowired
    PassengersService passengersService;

    @Autowired



    @GetMapping("/flightslist/tickets/{id}")
    public ModelAndView showTicketOptions(){
       ModelAndView mav = new ModelAndView();
       mav.setViewName("buy_ticket");
       mav.addObject("planeClass", ticketService.getPlaneClass());
        System.out.println("hello");
       return mav;
    }

    @PostMapping("/flightslist/tickets/{id}")
    public ModelAndView buyTicket(HttpSession session, @RequestParam String className, @PathVariable int id){
        ModelAndView mav = new ModelAndView();

        if (passengersService.getNumberOfAvailableSeatsByFlightId(id) >=1) {
            ticketService.makeTicket(id, Integer.parseInt(ticketService.getPriceByName(className)), (String) session.getAttribute("logged_user"));
            TicketModel ticketModel = ticketService.getTicketByTicketId((String) session.getAttribute("logged_user"));
            passengersService.registerPassengerToFlight((String) session.getAttribute("logged_user"), ticketModel.getTicketId(), id);
            passengersService.changeNumberOfAvailableSeats(id);
            mav.setViewName("redirect:/flightslist");
        }else {
            mav.addObject("no-free-sits-left","Sorry, but there are no free seats left, for this flight. We are sorry for the inconvenience.");
        }
       return mav;
    }

    @GetMapping("/flightslist/cancel/{id}")
    public ModelAndView cancelTicket(HttpSession session){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/flightslist");
        ticketService.cancelTicket((String) session.getAttribute("logged_user"));
        return mav;
    }
}



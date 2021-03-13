package com.example.AirportApp.Controllers;
import com.example.AirportApp.Models.UserModel;
//import com.example.AirportApp.Security.ApplicationUserRole;
import com.example.AirportApp.Services.FlightsService;
import com.example.AirportApp.Services.LoginService;
import com.example.AirportApp.Services.RegistrationService;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpResponse;

//import static com.example.AirportApp.Security.ApplicationUserRole.ADMIN;


@Controller
public class LoginController {
    @Autowired
    FlightsService flightsService;

    @Autowired
    LoginService loginService;

    @Autowired
   RegistrationService registrationService;

  //  ApplicationUserRole applicationUserRole;

    @GetMapping("/home")
    public String displayLogin(){
        return "index";
    }

    @PostMapping("/loginpage")
        public ModelAndView doLogin (HttpSession session, UserModel userModel){
   //     Response response = new Response();
        ModelAndView mav = new ModelAndView();
        try {
            if (loginService.getEmailWithPassword(userModel.getPassword()).contains(loginService.getEmailWithName(userModel.getUserName()))
                    && registrationService.checkIsEnabledByName(userModel.getUserName())) {
                if (!loginService.isAdmin(loginService.getEmailWithName(userModel.getUserName()))){
                    session.setAttribute("logged_user", userModel.getUserName());
                }else if (loginService.isAdmin(loginService.getEmailWithName(userModel.getUserName()))){
                    session.setAttribute("admin", userModel.getUserName());
                }
                   mav.setViewName("redirect:/flightslist");
            }else if (loginService.getEmailWithPassword(userModel.getPassword()).contains(loginService.getEmailWithName(userModel.getUserName())) && !registrationService.checkIsEnabledByName(userModel.getUserName())){
                mav.addObject("error", "Your account is has not been verified yet, please go to your email and verify your account");
                mav.setViewName("redirect:/eroare");
            }
            else {
                mav.addObject("error", "The user name and/or password are incorrect");
                mav.setViewName("redirect:/eroare");
            }
        }catch (EmptyResultDataAccessException e){
            mav.addObject("error", "To complete the user and password labels is mandatory to login in your account");
            mav.setViewName("redirect:/eroare");
        }
        return mav;
    }
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/home");
    }
}

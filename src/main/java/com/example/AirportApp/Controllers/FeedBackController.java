package com.example.AirportApp.Controllers;

import com.example.AirportApp.Models.FeedBack;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ValidationException;

@RestController
public class FeedBackController {
    private EmailConfiguration emailConfiguration;
    public FeedBackController(EmailConfiguration emailConfiguration) {
        this.emailConfiguration = emailConfiguration;
    }
    @PostMapping("/feedback")
    public ModelAndView sendFeedback(FeedBack feedBack, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException("Feedback is not valid");
        }
        //Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfiguration.getHost());
        mailSender.setPort(this.emailConfiguration.getPort());
        mailSender.setUsername(this.emailConfiguration.getUserName());
        mailSender.setPassword(this.emailConfiguration.getPassword());

        //Create an email instance
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(feedBack.getEmail());
        simpleMailMessage.setTo("tapusacodrin@yahoo.ro");
        simpleMailMessage.setSubject("New feedback from " + feedBack.getName());
        simpleMailMessage.setText(feedBack.getFeedback());

        //Send mail
        mailSender.send(simpleMailMessage);
        System.out.println("email sent");
        return new ModelAndView("redirect:/index.html");
    }
}

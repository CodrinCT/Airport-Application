package com.example.AirportApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.AirportApp.Controllers","com.example.AirportApp.Services",
        "com.example.AirportApp.Dao","com.example.AirportApp.Models", "com.example.AirportApp.Security"})
public class AirportAppApplication {



	public static void main(String[] args) {
		SpringApplication.run(AirportAppApplication.class, args);
	}

}

package com.JavaSchool.StudentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.JavaSchool.StudentSystem.model.Passenger;
import com.JavaSchool.StudentSystem.service.PassengerService;

@RestController
@RequestMapping("/passenger")

public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @PostMapping("/add")
    public String add( @RequestBody Passenger passenger ){
        passengerService.savePassenger(passenger);
        return "New passenger is added";
    }

    @GetMapping("/getAll")
    public List<Passenger> getAllPassenger(){
        return passengerService.getAllPassengers();
    }
    
}

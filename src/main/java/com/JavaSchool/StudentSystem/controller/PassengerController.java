package com.JavaSchool.StudentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.JavaSchool.StudentSystem.model.Passenger;
import com.JavaSchool.StudentSystem.service.PassengerService;

@RestController
@RequestMapping("/passenger")
@CrossOrigin

public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/add")
    public String add(@RequestBody Passenger passenger) {
        passengerService.savePassenger(passenger);
        return "New passenger is added";
    }

    @GetMapping("/getAll")
    public List<Passenger> getAllPassenger() {
        return passengerService.getAllPassengers();
    }


    @GetMapping("/passengerTrain")
    public ResponseEntity<?> passengerTrain(@RequestParam int filterIdShedule){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(passengerService.passengerTrain(filterIdShedule));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+ e.getMessage()+ "\"}"));

        }
    }

}

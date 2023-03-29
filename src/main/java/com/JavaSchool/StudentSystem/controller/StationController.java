package com.JavaSchool.StudentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.JavaSchool.StudentSystem.model.Station;
import com.JavaSchool.StudentSystem.service.StationService;

@RestController
@RequestMapping("/station")
@CrossOrigin

public class StationController {

    @Autowired
    private StationService stationService;

    @PostMapping("/add")
    public String add(@RequestBody Station station) {
        try{
            stationService.saveStation(station);
            return "New station is added";
        }catch(Exception e){
            return "error: " + e.getMessage();
        }
    }

    @GetMapping("/getAll")
    public List<Station> getAllStation() {
        return stationService.getAllStation();
    }

}

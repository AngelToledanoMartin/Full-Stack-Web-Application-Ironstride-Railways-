package com.JavaSchool.StudentSystem.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import com.JavaSchool.StudentSystem.model.Station;
import com.JavaSchool.StudentSystem.service.StationService;

    
@RestController
@RequestMapping("/station")
@CrossOrigin

public class StationControllerTest{

    @Autowired
    private StationService stationService;

    @Test
    @PostMapping("/add")
    public String add(@RequestBody Station station) {
        stationService.saveStation(station);
        return "New station is added";
    }

    @Test
    @GetMapping("/getAll")
    public List<Station> getAllStation() {
        return stationService.getAllStation();
    }

}

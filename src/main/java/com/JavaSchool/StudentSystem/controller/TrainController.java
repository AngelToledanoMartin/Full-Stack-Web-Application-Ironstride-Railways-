package com.JavaSchool.StudentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.JavaSchool.StudentSystem.model.Train;
import com.JavaSchool.StudentSystem.service.TrainService;

@RestController
@RequestMapping("/train")
@CrossOrigin

public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping("/add")
    public String add(@RequestBody Train train) {
        trainService.saveTrain(train);
        return "New train is added";
    }

    @GetMapping("/getAll")
    public List<Train> getAllTrain() {
        return trainService.getAllTrain();
    }


    
}

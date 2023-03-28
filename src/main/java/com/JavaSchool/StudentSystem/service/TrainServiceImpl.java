package com.JavaSchool.StudentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaSchool.StudentSystem.model.Train;
import com.JavaSchool.StudentSystem.repository.TrainRepository;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Override
    public Train saveTrain(Train train) {
        return trainRepository.save(train);
    }

    @Override
    public List<Train> getAllTrain() {
        return trainRepository.findAll();
    }

    
}

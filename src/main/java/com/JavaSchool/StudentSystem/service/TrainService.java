package com.JavaSchool.StudentSystem.service;

import java.util.List;

import com.JavaSchool.StudentSystem.model.Train;

public interface TrainService {
    public Train saveTrain(Train train);
    public List<Train> getAllTrain();
}

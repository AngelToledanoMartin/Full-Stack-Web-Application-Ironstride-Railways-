package com.JavaSchool.StudentSystem.service;

import java.util.List;

import com.JavaSchool.StudentSystem.model.Passenger;

public interface PassengerService {
    public Passenger savePassenger(Passenger passenger);
    public List<Passenger> getAllPassengers();
}

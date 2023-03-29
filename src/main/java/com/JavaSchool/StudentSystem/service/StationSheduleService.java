package com.JavaSchool.StudentSystem.service;

import java.util.List;

import com.JavaSchool.StudentSystem.model.Shedule;


public interface StationSheduleService {
    public List<Shedule> search(String filter);
    public List<Shedule> searchTrains(int stationA, int stationB, String dateA, String dateB);
}

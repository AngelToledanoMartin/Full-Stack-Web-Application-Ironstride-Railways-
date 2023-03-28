package com.JavaSchool.StudentSystem.service;

import java.util.List;

import com.JavaSchool.StudentSystem.model.Station;

public interface StationService {
    public Station saveStation(Station station);
    public List<Station> getAllStation();
}

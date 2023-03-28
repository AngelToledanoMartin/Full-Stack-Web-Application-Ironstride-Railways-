package com.JavaSchool.StudentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaSchool.StudentSystem.model.Station;
import com.JavaSchool.StudentSystem.repository.StationRepository;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository stationRepository;

    @Override
    public Station saveStation(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public List<Station> getAllStation() {
        return stationRepository.findAll();
    }

    
}

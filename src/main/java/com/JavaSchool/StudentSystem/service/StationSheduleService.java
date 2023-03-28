package com.JavaSchool.StudentSystem.service;

import java.util.List;

import com.JavaSchool.StudentSystem.model.Shedule;


public interface StationSheduleService {
    public List<Shedule> search(String filter);
}

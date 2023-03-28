package com.JavaSchool.StudentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaSchool.StudentSystem.model.Shedule;
import com.JavaSchool.StudentSystem.repository.SheduleRepository;

@Service
public class SearchSheduleServiceImpl implements SearchSheduleService {

    @Autowired
    private SheduleRepository sheduleRepository;

    @Override
    public List<Shedule> getAllShedule() {
        return sheduleRepository.findAll();
    }

    
}

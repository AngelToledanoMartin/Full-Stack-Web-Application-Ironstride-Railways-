package com.JavaSchool.StudentSystem.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.JavaSchool.StudentSystem.model.Shedule;
import com.JavaSchool.StudentSystem.repository.SheduleRepository;


@Service
public class StationSheduleServiceImpl implements StationSheduleService {

    @Autowired
    private SheduleRepository sheduleRepository;
  
/* 
    @Query(
            // dudas: si en stationrepository solo accedo a la clase "shedule" como hago
            // inner join a "station"
            value = "SELECT * FROM shedule INNER JOIN station ON station.id_station = shedule.id_StationStart WHERE station.name = :variable1", 
            nativeQuery = true)

    @Override
    public List<Shedule> getAllShedule(@Param("variable1") String variable1) {
        // dudas: no puede ser findall es un metodo que me devulve todo, yo quiero que
        // me devuelva el resultado de la query
        return sheduleRepository.findAll();
    }
*/


    @Override
    public List<Shedule> search(String filter) {
        List<Shedule> shedules = sheduleRepository.search(filter);
        return shedules;
    }

    

}

package com.JavaSchool.StudentSystem.service;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.JavaSchool.StudentSystem.model.Shedule;
import com.JavaSchool.StudentSystem.repository.SheduleRepository;


@Service
public class StationSheduleServiceImpl implements StationSheduleService {

    @Autowired
    private SheduleRepository sheduleRepository;
  

    @Override
    public List<Shedule> search(String filter) {
        List<Shedule> shedules = sheduleRepository.search(filter);
        return shedules;
    }

    public List<Shedule> searchTrains(int stationA, int stationB, String dateA, String dateB){

      

        String timestampString = dateA;
        Instant instant = Instant.parse(timestampString).truncatedTo(ChronoUnit.SECONDS);
        java.sql.Timestamp dateAa = java.sql.Timestamp.valueOf(instant.toString());

        String timestampString2 = dateB;
        Instant instant2 = Instant.parse(timestampString2).truncatedTo(ChronoUnit.SECONDS);
        java.sql.Timestamp dateBb = java.sql.Timestamp.valueOf(instant2.toString());

        String prueba="dsds";
        System.out.println(prueba);
        System.out.println(dateAa);
        System.out.println(dateBb);
        //java.sql.Timestamp dateAa = java.sql.Timestamp.valueOf(dateB); 
        //java.sql.Timestamp dateBb = java.sql.Timestamp.valueOf(dateB);

        List<Shedule> shedules = sheduleRepository.searchTrains(stationA, stationB, dateAa, dateBb);
        return shedules;
    }
    

}

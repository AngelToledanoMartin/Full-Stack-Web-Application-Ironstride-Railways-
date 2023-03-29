package com.JavaSchool.StudentSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.JavaSchool.StudentSystem.model.Shedule;

@Repository

public interface SheduleRepository extends JpaRepository<Shedule, Integer> {

    @Query(
            // dudas: si en stationrepository solo accedo a la clase "shedule" como hago
            // inner join a "station"
            // value = "SELECT * FROM shedule INNER JOIN station ON station.id_station =
            // shedule.id_StationStart WHERE station.name = :filter",
            value = "SELECT * FROM shedule WHERE id_station_start = :filter", nativeQuery = true)
    List<Shedule> search(@Param("filter") String filter);


    //to search a train from station a to station b between a date
    @Query(value = "SELECT id_train, id_shedule FROM shedule WHERE id_station_start = :stationA AND  id_station_end = :stationB AND date_start BETWEEN ':dateA' AND ':dateB'", nativeQuery = true)
    List<Shedule> searchTrains(@Param("stationA") int stationA, @Param("stationB") int stationB, @Param("dateA") java.sql.Timestamp dateA, @Param("dateB") java.sql.Timestamp dateB);

}

package com.JavaSchool.StudentSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.JavaSchool.StudentSystem.model.Passenger;

@Repository

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {


    @Query(value = "SELECT name, surname FROM passenger WHERE idpassenger IN (SELECT id_passenger FROM ticket WHERE id_shedule = :filterIdShedule )", nativeQuery = true)
    List<Passenger> passengerTrain(@Param("filterIdShedule") int filterIdShedule);
}

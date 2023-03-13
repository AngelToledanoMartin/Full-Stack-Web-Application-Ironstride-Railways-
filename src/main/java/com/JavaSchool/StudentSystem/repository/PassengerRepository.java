package com.JavaSchool.StudentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JavaSchool.StudentSystem.model.Passenger;

@Repository

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}

package com.JavaSchool.StudentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JavaSchool.StudentSystem.model.Station;

@Repository

public interface StationRepository extends JpaRepository<Station, Integer> {

}

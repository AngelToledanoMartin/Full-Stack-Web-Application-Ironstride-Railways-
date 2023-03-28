package com.JavaSchool.StudentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JavaSchool.StudentSystem.model.Train;

@Repository

public interface TrainRepository extends JpaRepository<Train, Integer> {

}

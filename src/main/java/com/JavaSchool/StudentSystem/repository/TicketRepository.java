package com.JavaSchool.StudentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JavaSchool.StudentSystem.model.Ticket;

@Repository

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}

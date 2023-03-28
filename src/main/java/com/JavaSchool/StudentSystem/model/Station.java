package com.JavaSchool.StudentSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

// Id_Station 	Name 	
public class Station {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int id_station;
        private String name;

        public Station() {

        }

        public int getId_station() {
                return id_station;
        }

        public void setId_station(int id_station) {
                this.id_station = id_station;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

}

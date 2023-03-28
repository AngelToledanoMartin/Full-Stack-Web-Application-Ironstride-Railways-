package com.JavaSchool.StudentSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

// id_shedule id_train date_end date_start id_station_end id_station_start
public class Shedule {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int id_shedule;
        private int id_train;
        private int id_station_start;
        private int id_station_end;
        private java.sql.Timestamp date_start;
        private java.sql.Timestamp date_end;

        public Shedule() {

        }

        public int getId_shedule() {
                return id_shedule;
        }

        public void setId_shedule(int Id_shedule) {
                this.id_shedule = Id_shedule;
        }

        public int getId_station_start() {
                return id_station_start;
        }

        public void setId_station_start(int id_station_start) {
                this.id_station_start = id_station_start;
        }

        public void setId_station_end(int id_station_end) {
                this.id_station_end = id_station_end;
        }

        public int getId_station_end() {
                return id_station_end;
        }

        public int getId_train() {
                return id_train;
        }

        public void setId_train(int id_train) {
                this.id_train = id_train;
        }

        public java.sql.Timestamp getDate_start() {
                return date_start;
        }

        public void setDate_start(java.sql.Timestamp date_start) {
                this.date_start = date_start;
        }

        public java.sql.Timestamp getDate_end() {
                return date_end;
        }

        public void setDate_end(java.sql.Timestamp date_end) {
                this.date_end = date_end;
        }

}

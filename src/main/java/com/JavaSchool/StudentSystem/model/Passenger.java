package com.JavaSchool.StudentSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity


public class Passenger {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int idpassenger;
        private String name;
        private String surname;
        private java.sql.Date birthday;

        public Passenger() {

        }

        public int getIdpassenger() {
                return idpassenger;
        }

        public void setIdpassenger(int idpassenger) {
                this.idpassenger = idpassenger;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getSurname() {
                return surname;
        }

        public void setSurname(String surname) {
                this.surname = surname;
        }

        public java.sql.Date getBirthday() {
                return birthday;
        }

        public void setBirthday(java.sql.Date birthday) {
                this.birthday = birthday;
        }
}

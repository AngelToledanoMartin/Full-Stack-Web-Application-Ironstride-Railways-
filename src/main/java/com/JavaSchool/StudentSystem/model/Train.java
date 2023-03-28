package com.JavaSchool.StudentSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

// Id_Train Avaliable_Seats id_train 	avaliable_seats 	
public class Train {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int id_Train;
        private int avaliable_seats;

        public Train() {

        }

        public int getId_Train() {
                return id_Train;
        }

        public void setId_Train(int id_Train) {
                this.id_Train = id_Train;
        }

        public int getAvaliable_seats() {
                return avaliable_seats;
        }

        public void setAvaliable_seats(int avaliable_seats) {
                this.avaliable_seats = avaliable_seats;
        }

}

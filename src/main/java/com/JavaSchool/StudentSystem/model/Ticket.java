package com.JavaSchool.StudentSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

//Id_Ticket 	Id_Passenger 	Id_Shedule 		
public class Ticket {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int IdTicket;
        private int IdPassenger;
        private int IdShedule;;
        public Ticket() {

        }

        public int getIdTicket() {
                return IdTicket;
        }

        public void setIdTicket(int IdTicket) {
                this.IdTicket = IdTicket;
        }

        public int getIdPassenger() {
                return IdPassenger;
        }

        public void setIdPassenger(int IdPassenger) {
                this.IdPassenger = IdPassenger;
        }

        public int getIdShedule() {
                return IdShedule;
        }

        public void setIdShedule(int IdShedule) {
                this.IdShedule = IdShedule;
        }


}

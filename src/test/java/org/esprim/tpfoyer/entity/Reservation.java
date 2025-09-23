package org.esprim.tpfoyer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private String idReservation;
    private Date anneeReservation;
    private boolean estValide;
}

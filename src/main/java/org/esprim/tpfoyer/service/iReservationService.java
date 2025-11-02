package org.esprim.tpfoyer.service;

import org.esprim.tpfoyer.entity.Reservation;

import java.util.List;

public interface iReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(Long reservationId);
    Reservation addReservation(Reservation r);
    void removeReservation(Long reservationId);
    Reservation modifyReservation(Reservation reservation);
}

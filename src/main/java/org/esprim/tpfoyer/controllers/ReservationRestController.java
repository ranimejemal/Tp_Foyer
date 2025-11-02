package org.esprim.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.entity.Reservation;
import org.esprim.tpfoyer.service.iReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    iReservationService iReservationService;

    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return iReservationService.retrieveAllReservations();
    }

    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String resId) {
        return iReservationService.retrieveReservation(resId);
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return iReservationService.addReservation(r);
    }

    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String resId) {
        iReservationService.removeReservation(resId);
    }

    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r) {
        return iReservationService.modifyReservation(r);
    }
}

package com.oasis.onlinereservationsystem.service;

import com.oasis.onlinereservationsystem.model.Reservation;

public interface ReservationService {
    void newReservation(Reservation reservation);
    Reservation findByPnrNumber(String pnr);

    void cancelTicket(String pnr);
}

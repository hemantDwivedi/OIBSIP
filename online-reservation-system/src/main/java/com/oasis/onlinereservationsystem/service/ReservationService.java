package com.oasis.onlinereservationsystem.service;

import com.oasis.onlinereservationsystem.model.Reservation;

public interface ReservationService {
    void newReservation(Reservation reservation);
    Reservation findByPnrNumber(String pnr);

    boolean cancelTicket(String pnr);
}

package com.oasis.onlinereservationsystem.repository;

import com.oasis.onlinereservationsystem.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findByPnr(String pnr);
}

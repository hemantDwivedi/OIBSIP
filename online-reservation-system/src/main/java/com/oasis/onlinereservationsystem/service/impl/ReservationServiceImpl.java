package com.oasis.onlinereservationsystem.service.impl;

import com.oasis.onlinereservationsystem.model.Reservation;
import com.oasis.onlinereservationsystem.repository.ReservationRepository;
import com.oasis.onlinereservationsystem.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository repository;
    @Override
    public void newReservation(Reservation reservation) {
        reservation.setPnr(pnrGenerator());
        repository.save(reservation);
    }

    @Override
    public Reservation findByPnrNumber(String pnr) {
        return repository.findByPnr(pnr);
    }

    private String pnrGenerator(){
        long min = 10000000L;
        long max = 99999999L;
        long pnrNum = (long) Math.floor(Math.random() * (max - min + 1) + min);
        return String.valueOf(pnrNum);
    }
}

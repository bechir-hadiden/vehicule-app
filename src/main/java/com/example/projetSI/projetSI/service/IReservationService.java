package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Reservation;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(Long reservationId);
    Reservation addReservation(Reservation reservation);
    Reservation modifyReservation(Reservation reservation);
    void removeReservation(Long reservationId);
}

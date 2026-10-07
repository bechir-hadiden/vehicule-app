package com.example.projetSI.projetSI.repository;

import com.example.projetSI.projetSI.domain.Reservation;
import com.example.projetSI.projetSI.domain.StatutReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByClient_IdClient(Long idClient);
    List<Reservation> findByVehicule_IdVehicule(Long idVehicule);
    List<Reservation> findByStatut(StatutReservation statut);
}

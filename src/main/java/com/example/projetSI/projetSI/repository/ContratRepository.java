package com.example.projetSI.projetSI.repository;

import com.example.projetSI.projetSI.domain.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
    List<Contrat> findByValide(Boolean valide);
    List<Contrat> findByReservation_IdReservation(Long idReservation);
}

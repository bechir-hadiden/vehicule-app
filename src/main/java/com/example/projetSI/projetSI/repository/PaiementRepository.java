package com.example.projetSI.projetSI.repository;

import com.example.projetSI.projetSI.domain.ModePaiement;
import com.example.projetSI.projetSI.domain.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findByContrat_IdContrat(Long idContrat);
    List<Paiement> findByModePaiement(ModePaiement modePaiement);
}

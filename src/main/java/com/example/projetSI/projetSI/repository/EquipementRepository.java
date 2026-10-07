package com.example.projetSI.projetSI.repository;

import com.example.projetSI.projetSI.domain.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
    Optional<Equipement> findByLibelle(String libelle);
}

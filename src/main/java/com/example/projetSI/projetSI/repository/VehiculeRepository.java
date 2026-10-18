package com.example.projetSI.projetSI.repository;

import com.example.projetSI.projetSI.domain.CategorieVehicule;
import com.example.projetSI.projetSI.domain.StatutVehicule;
import com.example.projetSI.projetSI.domain.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    List<Vehicule> findByImmatriculation(String immatriculation);
    List<Vehicule> findByMarque(String marque);
    List<Vehicule> findByStatut(StatutVehicule statut);
    List<Vehicule> findByCategorie(CategorieVehicule categorie);
    List<Vehicule> findByAgence_IdAgence(Long idAgence);
}

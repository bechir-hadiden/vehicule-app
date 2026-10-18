package com.example.projetSI.projetSI.repository;

import com.example.projetSI.projetSI.domain.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
    List<Agence> findByNom(String nom);
    List<Agence> findByVille(String ville);
}

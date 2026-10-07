package com.example.projetSI.projetSI.repository;

import com.example.projetSI.projetSI.domain.Employe;
import com.example.projetSI.projetSI.domain.RoleEmploye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    List<Employe> findByRole(RoleEmploye role);
    List<Employe> findByAgence_IdAgence(Long idAgence);
}

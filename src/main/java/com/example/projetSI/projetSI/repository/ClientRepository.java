package com.example.projetSI.projetSI.repository;

import com.example.projetSI.projetSI.domain.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByEmail(String email);
    List<Client> findByNumPermis(String numPermis);
}

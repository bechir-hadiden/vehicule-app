package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Agence;
import java.util.List;

public interface IAgenceService {
    List<Agence> retrieveAllAgences();
    Agence retrieveAgence(Long agenceId);
    Agence addAgence(Agence agence);
    Agence modifyAgence(Agence agence);
    void removeAgence(Long agenceId);
}

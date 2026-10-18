package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Contrat;
import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat retrieveContrat(Long contratId);
    Contrat addContrat(Contrat contrat);
    Contrat modifyContrat(Contrat contrat);
    void removeContrat(Long contratId);
}

package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Paiement;
import java.util.List;

public interface IPaiementService {
    List<Paiement> retrieveAllPaiements();
    Paiement retrievePaiement(Long paiementId);
    Paiement addPaiement(Paiement paiement);
    Paiement modifyPaiement(Paiement paiement);
    void removePaiement(Long paiementId);
}

package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Paiement;
import com.example.projetSI.projetSI.repository.PaiementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final PaiementRepository paiementRepository;

    @Override
    public List<Paiement> retrieveAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement retrievePaiement(Long paiementId) {
        return paiementRepository.findById(paiementId).orElse(null);
    }

    @Override
    public Paiement addPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement modifyPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void removePaiement(Long paiementId) {
        paiementRepository.deleteById(paiementId);
    }
}

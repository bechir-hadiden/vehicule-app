package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Contrat;
import com.example.projetSI.projetSI.repository.ContratRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final ContratRepository contratRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat retrieveContrat(Long contratId) {
        return contratRepository.findById(contratId).orElse(null);
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat modifyContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void removeContrat(Long contratId) {
        contratRepository.deleteById(contratId);
    }
}

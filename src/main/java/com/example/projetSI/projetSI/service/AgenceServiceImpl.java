package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Agence;
import com.example.projetSI.projetSI.repository.AgenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final AgenceRepository agenceRepository;

    @Override
    public List<Agence> retrieveAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence retrieveAgence(Long agenceId) {
        return agenceRepository.findById(agenceId).orElse(null);
    }

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence modifyAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void removeAgence(Long agenceId) {
        agenceRepository.deleteById(agenceId);
    }
}

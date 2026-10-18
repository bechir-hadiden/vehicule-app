package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Equipement;
import com.example.projetSI.projetSI.repository.EquipementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final EquipementRepository equipementRepository;

    @Override
    public List<Equipement> retrieveAllEquipements() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement retrieveEquipement(Long equipementId) {
        return equipementRepository.findById(equipementId).orElse(null);
    }

    @Override
    public Equipement addEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement modifyEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void removeEquipement(Long equipementId) {
        equipementRepository.deleteById(equipementId);
    }
}

package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Vehicule;
import com.example.projetSI.projetSI.repository.VehiculeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;

    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule retrieveVehicule(Long vehiculeId) {
        return vehiculeRepository.findById(vehiculeId).orElse(null);
    }

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifyVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void removeVehicule(Long vehiculeId) {
        vehiculeRepository.deleteById(vehiculeId);
    }
}

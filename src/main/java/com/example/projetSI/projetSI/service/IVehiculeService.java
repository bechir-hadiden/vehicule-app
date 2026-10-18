package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Vehicule;
import java.util.List;

public interface IVehiculeService {
    List<Vehicule> retrieveAllVehicules();
    Vehicule retrieveVehicule(Long vehiculeId);
    Vehicule addVehicule(Vehicule vehicule);
    Vehicule modifyVehicule(Vehicule vehicule);
    void removeVehicule(Long vehiculeId);
}

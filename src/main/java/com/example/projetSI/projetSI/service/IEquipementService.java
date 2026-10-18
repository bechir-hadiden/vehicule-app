package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Equipement;
import java.util.List;

public interface IEquipementService {
    List<Equipement> retrieveAllEquipements();
    Equipement retrieveEquipement(Long equipementId);
    Equipement addEquipement(Equipement equipement);
    Equipement modifyEquipement(Equipement equipement);
    void removeEquipement(Long equipementId);
}

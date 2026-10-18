package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Maintenance;
import com.example.projetSI.projetSI.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance retrieveMaintenance(Long maintenanceId) {
        return maintenanceRepository.findById(maintenanceId).orElse(null);
    }

    @Override
    public Maintenance addMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance modifyMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void removeMaintenance(Long maintenanceId) {
        maintenanceRepository.deleteById(maintenanceId);
    }
}

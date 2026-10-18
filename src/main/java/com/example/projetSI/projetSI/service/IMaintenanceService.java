package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Maintenance;
import java.util.List;

public interface IMaintenanceService {
    List<Maintenance> retrieveAllMaintenances();
    Maintenance retrieveMaintenance(Long maintenanceId);
    Maintenance addMaintenance(Maintenance maintenance);
    Maintenance modifyMaintenance(Maintenance maintenance);
    void removeMaintenance(Long maintenanceId);
}

package com.example.projetSI.projetSI.web.controller;

import com.example.projetSI.projetSI.domain.Maintenance;
import com.example.projetSI.projetSI.service.IMaintenanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Maintenances", description = "Gestion des operations CRUD pour l'entite Maintenance")
@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
@CrossOrigin(origins = "*")
public class MaintenanceRestController {

    private final IMaintenanceService maintenanceService;

    @Operation(summary = "Recuperer tous les maintenances", description = "Permet de recuperer la liste complete de toutes les entites Maintenance en base de donnees")
    @GetMapping({"/retrieve-all-maintenances", ""})
    public List<Maintenance> getMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    @Operation(summary = "Recuperer un(e) maintenance par son identifiant", description = "Permet de recuperer un(e) Maintenance grace a son ID unique")
    @GetMapping({"/retrieve-maintenance/{maintenance-id}", "/{maintenance-id}"} )
    public Maintenance retrieveMaintenance(@PathVariable("maintenance-id") Long maintenanceId) {
        return maintenanceService.retrieveMaintenance(maintenanceId);
    }

    @Operation(summary = "Ajouter un(e) nouveau(elle) maintenance", description = "Permet d'ajouter et d'enregistrer un(e) nouvel(le) Maintenance dans la base")
    @PostMapping({"/add-maintenance", ""})
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    @Operation(summary = "Modifier un(e) maintenance", description = "Permet de mettre a jour les informations d'un(e) Maintenance existant(e)")
    @PutMapping({"/modify-maintenance", ""})
    public Maintenance modifyMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifyMaintenance(maintenance);
    }

    @Operation(summary = "Supprimer un(e) maintenance par son identifiant", description = "Permet de supprimer un(e) Maintenance de la base a partir de son ID")
    @DeleteMapping({"/remove-maintenance/{maintenance-id}", "/{maintenance-id}"} )
    public void removeMaintenance(@PathVariable("maintenance-id") Long maintenanceId) {
        maintenanceService.removeMaintenance(maintenanceId);
    }

    @Operation(summary = "Supprimer un(e) maintenance via parametre de requete", description = "Suppression alternative par Query Param (ex: ?maintenanceId=1)")
    @DeleteMapping("/remove-maintenance")
    public void removeMaintenanceByParam(@RequestParam(value = "maintenanceId", required = false) Long paramId,
                                   @RequestParam(value = "maintenance-id", required = false) Long pathParamId,
                                   @RequestParam(value = "id", required = false) Long genericId) {
        Long targetId = paramId != null ? paramId : (pathParamId != null ? pathParamId : genericId);
        if (targetId != null) {
            maintenanceService.removeMaintenance(targetId);
        }
    }
}

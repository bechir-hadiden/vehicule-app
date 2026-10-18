package com.example.projetSI.projetSI.web.controller;

import com.example.projetSI.projetSI.domain.Vehicule;
import com.example.projetSI.projetSI.service.IVehiculeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Véhicules", description = "Gestion des operations CRUD pour l'entite Vehicule")
@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
@CrossOrigin(origins = "*")
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    @Operation(summary = "Recuperer tous les vehicules", description = "Permet de recuperer la liste complete de toutes les entites Vehicule en base de donnees")
    @GetMapping({"/retrieve-all-vehicules", ""})
    public List<Vehicule> getVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @Operation(summary = "Recuperer un(e) vehicule par son identifiant", description = "Permet de recuperer un(e) Vehicule grace a son ID unique")
    @GetMapping({"/retrieve-vehicule/{vehicule-id}", "/{vehicule-id}"} )
    public Vehicule retrieveVehicule(@PathVariable("vehicule-id") Long vehiculeId) {
        return vehiculeService.retrieveVehicule(vehiculeId);
    }

    @Operation(summary = "Ajouter un(e) nouveau(elle) vehicule", description = "Permet d'ajouter et d'enregistrer un(e) nouvel(le) Vehicule dans la base")
    @PostMapping({"/add-vehicule", ""})
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @Operation(summary = "Modifier un(e) vehicule", description = "Permet de mettre a jour les informations d'un(e) Vehicule existant(e)")
    @PutMapping({"/modify-vehicule", ""})
    public Vehicule modifyVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifyVehicule(vehicule);
    }

    @Operation(summary = "Supprimer un(e) vehicule par son identifiant", description = "Permet de supprimer un(e) Vehicule de la base a partir de son ID")
    @DeleteMapping({"/remove-vehicule/{vehicule-id}", "/{vehicule-id}"} )
    public void removeVehicule(@PathVariable("vehicule-id") Long vehiculeId) {
        vehiculeService.removeVehicule(vehiculeId);
    }

    @Operation(summary = "Supprimer un(e) vehicule via parametre de requete", description = "Suppression alternative par Query Param (ex: ?vehiculeId=1)")
    @DeleteMapping("/remove-vehicule")
    public void removeVehiculeByParam(@RequestParam(value = "vehiculeId", required = false) Long paramId,
                                   @RequestParam(value = "vehicule-id", required = false) Long pathParamId,
                                   @RequestParam(value = "id", required = false) Long genericId) {
        Long targetId = paramId != null ? paramId : (pathParamId != null ? pathParamId : genericId);
        if (targetId != null) {
            vehiculeService.removeVehicule(targetId);
        }
    }
}

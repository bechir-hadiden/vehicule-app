package com.example.projetSI.projetSI.web.controller;

import com.example.projetSI.projetSI.domain.Equipement;
import com.example.projetSI.projetSI.service.IEquipementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Équipements", description = "Gestion des operations CRUD pour l'entite Equipement")
@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
@CrossOrigin(origins = "*")
public class EquipementRestController {

    private final IEquipementService equipementService;

    @Operation(summary = "Recuperer tous les equipements", description = "Permet de recuperer la liste complete de toutes les entites Equipement en base de donnees")
    @GetMapping({"/retrieve-all-equipements", ""})
    public List<Equipement> getEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    @Operation(summary = "Recuperer un(e) equipement par son identifiant", description = "Permet de recuperer un(e) Equipement grace a son ID unique")
    @GetMapping({"/retrieve-equipement/{equipement-id}", "/{equipement-id}"} )
    public Equipement retrieveEquipement(@PathVariable("equipement-id") Long equipementId) {
        return equipementService.retrieveEquipement(equipementId);
    }

    @Operation(summary = "Ajouter un(e) nouveau(elle) equipement", description = "Permet d'ajouter et d'enregistrer un(e) nouvel(le) Equipement dans la base")
    @PostMapping({"/add-equipement", ""})
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    @Operation(summary = "Modifier un(e) equipement", description = "Permet de mettre a jour les informations d'un(e) Equipement existant(e)")
    @PutMapping({"/modify-equipement", ""})
    public Equipement modifyEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifyEquipement(equipement);
    }

    @Operation(summary = "Supprimer un(e) equipement par son identifiant", description = "Permet de supprimer un(e) Equipement de la base a partir de son ID")
    @DeleteMapping({"/remove-equipement/{equipement-id}", "/{equipement-id}"} )
    public void removeEquipement(@PathVariable("equipement-id") Long equipementId) {
        equipementService.removeEquipement(equipementId);
    }

    @Operation(summary = "Supprimer un(e) equipement via parametre de requete", description = "Suppression alternative par Query Param (ex: ?equipementId=1)")
    @DeleteMapping("/remove-equipement")
    public void removeEquipementByParam(@RequestParam(value = "equipementId", required = false) Long paramId,
                                   @RequestParam(value = "equipement-id", required = false) Long pathParamId,
                                   @RequestParam(value = "id", required = false) Long genericId) {
        Long targetId = paramId != null ? paramId : (pathParamId != null ? pathParamId : genericId);
        if (targetId != null) {
            equipementService.removeEquipement(targetId);
        }
    }
}

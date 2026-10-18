package com.example.projetSI.projetSI.web.controller;

import com.example.projetSI.projetSI.domain.Agence;
import com.example.projetSI.projetSI.service.IAgenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Agences", description = "Gestion des operations CRUD pour l'entite Agence")
@RestController
@AllArgsConstructor
@RequestMapping("/agence")
@CrossOrigin(origins = "*")
public class AgenceRestController {

    private final IAgenceService agenceService;

    @Operation(summary = "Recuperer tous les agences", description = "Permet de recuperer la liste complete de toutes les entites Agence en base de donnees")
    @GetMapping({"/retrieve-all-agences", ""})
    public List<Agence> getAgences() {
        return agenceService.retrieveAllAgences();
    }

    @Operation(summary = "Recuperer un(e) agence par son identifiant", description = "Permet de recuperer un(e) Agence grace a son ID unique")
    @GetMapping({"/retrieve-agence/{agence-id}", "/{agence-id}"} )
    public Agence retrieveAgence(@PathVariable("agence-id") Long agenceId) {
        return agenceService.retrieveAgence(agenceId);
    }

    @Operation(summary = "Ajouter un(e) nouveau(elle) agence", description = "Permet d'ajouter et d'enregistrer un(e) nouvel(le) Agence dans la base")
    @PostMapping({"/add-agence", ""})
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @Operation(summary = "Modifier un(e) agence", description = "Permet de mettre a jour les informations d'un(e) Agence existant(e)")
    @PutMapping({"/modify-agence", ""})
    public Agence modifyAgence(@RequestBody Agence agence) {
        return agenceService.modifyAgence(agence);
    }

    @Operation(summary = "Supprimer un(e) agence par son identifiant", description = "Permet de supprimer un(e) Agence de la base a partir de son ID")
    @DeleteMapping({"/remove-agence/{agence-id}", "/{agence-id}"} )
    public void removeAgence(@PathVariable("agence-id") Long agenceId) {
        agenceService.removeAgence(agenceId);
    }

    @Operation(summary = "Supprimer un(e) agence via parametre de requete", description = "Suppression alternative par Query Param (ex: ?agenceId=1)")
    @DeleteMapping("/remove-agence")
    public void removeAgenceByParam(@RequestParam(value = "agenceId", required = false) Long paramId,
                                   @RequestParam(value = "agence-id", required = false) Long pathParamId,
                                   @RequestParam(value = "id", required = false) Long genericId) {
        Long targetId = paramId != null ? paramId : (pathParamId != null ? pathParamId : genericId);
        if (targetId != null) {
            agenceService.removeAgence(targetId);
        }
    }
}

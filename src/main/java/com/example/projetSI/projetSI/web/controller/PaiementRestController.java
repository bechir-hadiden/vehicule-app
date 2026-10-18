package com.example.projetSI.projetSI.web.controller;

import com.example.projetSI.projetSI.domain.Paiement;
import com.example.projetSI.projetSI.service.IPaiementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Paiements", description = "Gestion des operations CRUD pour l'entite Paiement")
@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
@CrossOrigin(origins = "*")
public class PaiementRestController {

    private final IPaiementService paiementService;

    @Operation(summary = "Recuperer tous les paiements", description = "Permet de recuperer la liste complete de toutes les entites Paiement en base de donnees")
    @GetMapping({"/retrieve-all-paiements", ""})
    public List<Paiement> getPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    @Operation(summary = "Recuperer un(e) paiement par son identifiant", description = "Permet de recuperer un(e) Paiement grace a son ID unique")
    @GetMapping({"/retrieve-paiement/{paiement-id}", "/{paiement-id}"} )
    public Paiement retrievePaiement(@PathVariable("paiement-id") Long paiementId) {
        return paiementService.retrievePaiement(paiementId);
    }

    @Operation(summary = "Ajouter un(e) nouveau(elle) paiement", description = "Permet d'ajouter et d'enregistrer un(e) nouvel(le) Paiement dans la base")
    @PostMapping({"/add-paiement", ""})
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    @Operation(summary = "Modifier un(e) paiement", description = "Permet de mettre a jour les informations d'un(e) Paiement existant(e)")
    @PutMapping({"/modify-paiement", ""})
    public Paiement modifyPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifyPaiement(paiement);
    }

    @Operation(summary = "Supprimer un(e) paiement par son identifiant", description = "Permet de supprimer un(e) Paiement de la base a partir de son ID")
    @DeleteMapping({"/remove-paiement/{paiement-id}", "/{paiement-id}"} )
    public void removePaiement(@PathVariable("paiement-id") Long paiementId) {
        paiementService.removePaiement(paiementId);
    }

    @Operation(summary = "Supprimer un(e) paiement via parametre de requete", description = "Suppression alternative par Query Param (ex: ?paiementId=1)")
    @DeleteMapping("/remove-paiement")
    public void removePaiementByParam(@RequestParam(value = "paiementId", required = false) Long paramId,
                                   @RequestParam(value = "paiement-id", required = false) Long pathParamId,
                                   @RequestParam(value = "id", required = false) Long genericId) {
        Long targetId = paramId != null ? paramId : (pathParamId != null ? pathParamId : genericId);
        if (targetId != null) {
            paiementService.removePaiement(targetId);
        }
    }
}

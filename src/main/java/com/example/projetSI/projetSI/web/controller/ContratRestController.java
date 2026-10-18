package com.example.projetSI.projetSI.web.controller;

import com.example.projetSI.projetSI.domain.Contrat;
import com.example.projetSI.projetSI.service.IContratService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Contrats", description = "Gestion des operations CRUD pour l'entite Contrat")
@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
@CrossOrigin(origins = "*")
public class ContratRestController {

    private final IContratService contratService;

    @Operation(summary = "Recuperer tous les contrats", description = "Permet de recuperer la liste complete de toutes les entites Contrat en base de donnees")
    @GetMapping({"/retrieve-all-contrats", ""})
    public List<Contrat> getContrats() {
        return contratService.retrieveAllContrats();
    }

    @Operation(summary = "Recuperer un(e) contrat par son identifiant", description = "Permet de recuperer un(e) Contrat grace a son ID unique")
    @GetMapping({"/retrieve-contrat/{contrat-id}", "/{contrat-id}"} )
    public Contrat retrieveContrat(@PathVariable("contrat-id") Long contratId) {
        return contratService.retrieveContrat(contratId);
    }

    @Operation(summary = "Ajouter un(e) nouveau(elle) contrat", description = "Permet d'ajouter et d'enregistrer un(e) nouvel(le) Contrat dans la base")
    @PostMapping({"/add-contrat", ""})
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @Operation(summary = "Modifier un(e) contrat", description = "Permet de mettre a jour les informations d'un(e) Contrat existant(e)")
    @PutMapping({"/modify-contrat", ""})
    public Contrat modifyContrat(@RequestBody Contrat contrat) {
        return contratService.modifyContrat(contrat);
    }

    @Operation(summary = "Supprimer un(e) contrat par son identifiant", description = "Permet de supprimer un(e) Contrat de la base a partir de son ID")
    @DeleteMapping({"/remove-contrat/{contrat-id}", "/{contrat-id}"} )
    public void removeContrat(@PathVariable("contrat-id") Long contratId) {
        contratService.removeContrat(contratId);
    }

    @Operation(summary = "Supprimer un(e) contrat via parametre de requete", description = "Suppression alternative par Query Param (ex: ?contratId=1)")
    @DeleteMapping("/remove-contrat")
    public void removeContratByParam(@RequestParam(value = "contratId", required = false) Long paramId,
                                   @RequestParam(value = "contrat-id", required = false) Long pathParamId,
                                   @RequestParam(value = "id", required = false) Long genericId) {
        Long targetId = paramId != null ? paramId : (pathParamId != null ? pathParamId : genericId);
        if (targetId != null) {
            contratService.removeContrat(targetId);
        }
    }
}

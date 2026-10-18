package com.example.projetSI.projetSI.web.controller;

import com.example.projetSI.projetSI.domain.Employe;
import com.example.projetSI.projetSI.service.IEmployeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Employés", description = "Gestion des operations CRUD pour l'entite Employe")
@RestController
@AllArgsConstructor
@RequestMapping("/employe")
@CrossOrigin(origins = "*")
public class EmployeRestController {

    private final IEmployeService employeService;

    @Operation(summary = "Recuperer tous les employes", description = "Permet de recuperer la liste complete de toutes les entites Employe en base de donnees")
    @GetMapping({"/retrieve-all-employes", ""})
    public List<Employe> getEmployes() {
        return employeService.retrieveAllEmployes();
    }

    @Operation(summary = "Recuperer un(e) employe par son identifiant", description = "Permet de recuperer un(e) Employe grace a son ID unique")
    @GetMapping({"/retrieve-employe/{employe-id}", "/{employe-id}"} )
    public Employe retrieveEmploye(@PathVariable("employe-id") Long employeId) {
        return employeService.retrieveEmploye(employeId);
    }

    @Operation(summary = "Ajouter un(e) nouveau(elle) employe", description = "Permet d'ajouter et d'enregistrer un(e) nouvel(le) Employe dans la base")
    @PostMapping({"/add-employe", ""})
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @Operation(summary = "Modifier un(e) employe", description = "Permet de mettre a jour les informations d'un(e) Employe existant(e)")
    @PutMapping({"/modify-employe", ""})
    public Employe modifyEmploye(@RequestBody Employe employe) {
        return employeService.modifyEmploye(employe);
    }

    @Operation(summary = "Supprimer un(e) employe par son identifiant", description = "Permet de supprimer un(e) Employe de la base a partir de son ID")
    @DeleteMapping({"/remove-employe/{employe-id}", "/{employe-id}"} )
    public void removeEmploye(@PathVariable("employe-id") Long employeId) {
        employeService.removeEmploye(employeId);
    }

    @Operation(summary = "Supprimer un(e) employe via parametre de requete", description = "Suppression alternative par Query Param (ex: ?employeId=1)")
    @DeleteMapping("/remove-employe")
    public void removeEmployeByParam(@RequestParam(value = "employeId", required = false) Long paramId,
                                   @RequestParam(value = "employe-id", required = false) Long pathParamId,
                                   @RequestParam(value = "id", required = false) Long genericId) {
        Long targetId = paramId != null ? paramId : (pathParamId != null ? pathParamId : genericId);
        if (targetId != null) {
            employeService.removeEmploye(targetId);
        }
    }
}

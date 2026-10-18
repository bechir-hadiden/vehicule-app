package com.example.projetSI.projetSI.web.controller;

import com.example.projetSI.projetSI.domain.Client;
import com.example.projetSI.projetSI.service.IClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Clients", description = "Gestion des operations CRUD pour l'entite Client")
@RestController
@AllArgsConstructor
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientRestController {

    private final IClientService clientService;

    @Operation(summary = "Recuperer tous les clients", description = "Permet de recuperer la liste complete de toutes les entites Client en base de donnees")
    @GetMapping({"/retrieve-all-clients", ""})
    public List<Client> getClients() {
        return clientService.retrieveAllClients();
    }

    @Operation(summary = "Recuperer un(e) client par son identifiant", description = "Permet de recuperer un(e) Client grace a son ID unique")
    @GetMapping({"/retrieve-client/{client-id}", "/{client-id}"} )
    public Client retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.retrieveClient(clientId);
    }

    @Operation(summary = "Ajouter un(e) nouveau(elle) client", description = "Permet d'ajouter et d'enregistrer un(e) nouvel(le) Client dans la base")
    @PostMapping({"/add-client", ""})
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @Operation(summary = "Modifier un(e) client", description = "Permet de mettre a jour les informations d'un(e) Client existant(e)")
    @PutMapping({"/modify-client", ""})
    public Client modifyClient(@RequestBody Client client) {
        return clientService.modifyClient(client);
    }

    @Operation(summary = "Supprimer un(e) client par son identifiant", description = "Permet de supprimer un(e) Client de la base a partir de son ID")
    @DeleteMapping({"/remove-client/{client-id}", "/{client-id}"} )
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.removeClient(clientId);
    }

    @Operation(summary = "Supprimer un(e) client via parametre de requete", description = "Suppression alternative par Query Param (ex: ?clientId=1)")
    @DeleteMapping("/remove-client")
    public void removeClientByParam(@RequestParam(value = "clientId", required = false) Long paramId,
                                   @RequestParam(value = "client-id", required = false) Long pathParamId,
                                   @RequestParam(value = "id", required = false) Long genericId) {
        Long targetId = paramId != null ? paramId : (pathParamId != null ? pathParamId : genericId);
        if (targetId != null) {
            clientService.removeClient(targetId);
        }
    }
}

package com.example.projetSI.projetSI.web.controller;

import com.example.projetSI.projetSI.domain.Reservation;
import com.example.projetSI.projetSI.service.IReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Réservations", description = "Gestion des operations CRUD pour l'entite Reservation")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
@CrossOrigin(origins = "*")
public class ReservationRestController {

    private final IReservationService reservationService;

    @Operation(summary = "Recuperer tous les reservations", description = "Permet de recuperer la liste complete de toutes les entites Reservation en base de donnees")
    @GetMapping({"/retrieve-all-reservations", ""})
    public List<Reservation> getReservations() {
        return reservationService.retrieveAllReservations();
    }

    @Operation(summary = "Recuperer un(e) reservation par son identifiant", description = "Permet de recuperer un(e) Reservation grace a son ID unique")
    @GetMapping({"/retrieve-reservation/{reservation-id}", "/{reservation-id}"} )
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    @Operation(summary = "Ajouter un(e) nouveau(elle) reservation", description = "Permet d'ajouter et d'enregistrer un(e) nouvel(le) Reservation dans la base")
    @PostMapping({"/add-reservation", ""})
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @Operation(summary = "Modifier un(e) reservation", description = "Permet de mettre a jour les informations d'un(e) Reservation existant(e)")
    @PutMapping({"/modify-reservation", ""})
    public Reservation modifyReservation(@RequestBody Reservation reservation) {
        return reservationService.modifyReservation(reservation);
    }

    @Operation(summary = "Supprimer un(e) reservation par son identifiant", description = "Permet de supprimer un(e) Reservation de la base a partir de son ID")
    @DeleteMapping({"/remove-reservation/{reservation-id}", "/{reservation-id}"} )
    public void removeReservation(@PathVariable("reservation-id") Long reservationId) {
        reservationService.removeReservation(reservationId);
    }

    @Operation(summary = "Supprimer un(e) reservation via parametre de requete", description = "Suppression alternative par Query Param (ex: ?reservationId=1)")
    @DeleteMapping("/remove-reservation")
    public void removeReservationByParam(@RequestParam(value = "reservationId", required = false) Long paramId,
                                   @RequestParam(value = "reservation-id", required = false) Long pathParamId,
                                   @RequestParam(value = "id", required = false) Long genericId) {
        Long targetId = paramId != null ? paramId : (pathParamId != null ? pathParamId : genericId);
        if (targetId != null) {
            reservationService.removeReservation(targetId);
        }
    }
}

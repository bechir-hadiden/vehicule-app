package com.example.projetSI.projetSI.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"reservation", "paiements"})
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private LocalDate dateSignature;

    private Double montantTotal;

    private Boolean valide;

    // One Contrat <-> One Reservation (Owning side)
    @OneToOne
    @JoinColumn(name = "id_reservation", unique = true)
    private Reservation reservation;

    // One Contrat -> Many Paiements
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Paiement> paiements = new ArrayList<>();
}

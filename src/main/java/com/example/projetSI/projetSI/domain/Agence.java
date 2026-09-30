package com.example.projetSI.projetSI.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"vehicules", "employes"})
public class Agence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 100)
    private String ville;

    @Column(length = 255)
    private String adresse;

    @Column(length = 20)
    private String telephone;

    // One Agence -> Many Vehicules
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Vehicule> vehicules = new ArrayList<>();

    // One Agence -> Many Employes
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employe> employes = new ArrayList<>();
}

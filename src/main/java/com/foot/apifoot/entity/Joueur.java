package com.foot.apifoot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String poste;
    private int numeroMaillot;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}
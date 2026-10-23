package com.foot.apifoot.entity;

import jakarta.persistence.*;

@Entity
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String poste;
    private int numeroMaillot;

    public Joueur() {
    }

    public Joueur(String nom, String prenom, String poste, int numeroMaillot) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.numeroMaillot = numeroMaillot;
    }

    // Pense à générer les Getters et Setters pour toutes les variables ci-dessus !
    // Dans IntelliJ : Alt + Inser (ou clic droit -> Generate) -> Getters and Setters

}

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

    public String getNom() {
        return nom;
    }

    public Long getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPoste() {
        return poste;
    }

    public int getNumeroMaillot() {
        return numeroMaillot;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumeroMaillot(int numeroMaillot) {
        this.numeroMaillot = numeroMaillot;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

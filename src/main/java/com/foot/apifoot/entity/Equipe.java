package com.foot.apifoot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Getter
@Setter
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String ville;

    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Joueur> joueurs;
}
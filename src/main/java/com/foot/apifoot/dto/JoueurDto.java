package com.foot.apifoot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JoueurDto {

    @NotBlank(message = "Le nom du joueur est obligatoire")
    private String nom;

    @NotBlank(message = "Le prénom du joueur est obligatoire")
    private String prenom;

    @NotBlank(message = "Le poste est obligatoire")
    private String poste;

    private Integer numeroMaillot;

    private Long equipeId;
}
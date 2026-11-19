package com.foot.apifoot.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class JoueurDto {
    @NotBlank
    private String nom;
    private String prenom;
    private String poste;
    private int numeroMaillot;
    private Long equipeId;
}
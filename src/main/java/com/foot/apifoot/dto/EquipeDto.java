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
public class EquipeDto {

    @NotBlank(message = "Le nom de l'équipe est obligatoire")
    private String nom;

    @NotBlank(message = "La ville est obligatoire")
    private String ville;
}
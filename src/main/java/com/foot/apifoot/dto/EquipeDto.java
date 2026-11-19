package com.foot.apifoot.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class EquipeDto {
    @NotBlank
    private String nom;
    private String ville;
}
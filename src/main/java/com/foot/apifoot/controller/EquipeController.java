package com.foot.apifoot.controller;

import com.foot.apifoot.dto.EquipeDto;
import com.foot.apifoot.entity.Equipe;
import com.foot.apifoot.repository.EquipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/equipes")
@RequiredArgsConstructor
public class EquipeController {

    private final EquipeRepository equipeRepository;

    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipe createEquipe(@Valid @RequestBody EquipeDto equipeDto) {
        Equipe equipe = new Equipe();
        equipe.setNom(equipeDto.getNom());
        equipe.setVille(equipeDto.getVille());
        return equipeRepository.save(equipe);
    }
}
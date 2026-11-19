package com.foot.apifoot.controller;

import com.foot.apifoot.dto.EquipeDto;
import com.foot.apifoot.entity.Equipe;
import com.foot.apifoot.service.EquipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
@RequiredArgsConstructor
public class EquipeController {

    private final EquipeService equipeService;

    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeService.getToutesLesEquipes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable Long id) {
        return equipeService.getEquipeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipe createEquipe(@Valid @RequestBody EquipeDto equipeDto) {
        return equipeService.save(equipeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable Long id, @Valid @RequestBody EquipeDto equipeDto) {
        return equipeService.update(id, equipeDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable Long id) {
        return equipeService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
package com.foot.apifoot.controller;

import com.foot.apifoot.dto.JoueurDto;
import com.foot.apifoot.entity.Joueur;
import com.foot.apifoot.service.JoueurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.foot.apifoot.service.JoueurService;
import com.foot.apifoot.entity.Joueur;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/joueurs")
@RequiredArgsConstructor
public class JoueurController {

    private final JoueurService joueurService;

    @GetMapping
    public List<Joueur> getAllJoueurs() {
        return joueurService.getTousLesJoueurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable Long id) {
        Optional<Joueur> joueur = joueurService.getJoueurById(id);
        return joueur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Joueur createJoueur(@Valid @RequestBody JoueurDto joueurDto) {
        return joueurService.save(joueurDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Joueur> updateJoueur(@PathVariable Long id, @Valid @RequestBody JoueurDto joueurDto) {
        Joueur joueurMisAJour = joueurService.update(id, joueurDto);
        if (joueurMisAJour != null) {
            return ResponseEntity.ok(joueurMisAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoueur(@PathVariable Long id) {
        Optional<Joueur> joueurExistant = joueurService.getJoueurById(id);
        if (joueurExistant.isPresent()) {
            joueurService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
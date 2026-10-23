package com.foot.apifoot.controller;

import com.foot.apifoot.entity.Joueur;
import com.foot.apifoot.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/joueurs")
public class JoueurController {

    @Autowired
    private JoueurService joueurService;


    @GetMapping
    public List<Joueur> getAllJoueurs() {
        return joueurService.getTousLesJoueurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable Long id) {
        Optional<Joueur> joueur = joueurService.getJoueurById(id);
        if (joueur.isPresent()) {
            return ResponseEntity.ok(joueur.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Joueur createJoueur(@RequestBody Joueur joueur) {
        return joueurService.sauvegarderJoueur(joueur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Joueur> updateJoueur(@PathVariable Long id, @RequestBody Joueur detailsJoueur) {
        Optional<Joueur> joueurExistant = joueurService.getJoueurById(id);

        if (joueurExistant.isPresent()) {
            Joueur joueur = joueurExistant.get();
            joueur.setNom(detailsJoueur.getNom());
            joueur.setPrenom(detailsJoueur.getPrenom());
            joueur.setPoste(detailsJoueur.getPoste());
            joueur.setNumeroMaillot(detailsJoueur.getNumeroMaillot());

            return ResponseEntity.ok(joueurService.sauvegarderJoueur(joueur));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoueur(@PathVariable Long id) {
        Optional<Joueur> joueurExistant = joueurService.getJoueurById(id);

        if (joueurExistant.isPresent()) {
            joueurService.supprimerJoueur(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
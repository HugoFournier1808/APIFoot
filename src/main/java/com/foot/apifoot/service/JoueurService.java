package com.foot.apifoot.service;

import com.foot.apifoot.entity.Joueur;
import com.foot.apifoot.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoueurService {

    @Autowired
    private JoueurRepository joueurRepository;

    public List<Joueur> getTousLesJoueurs() {
        return joueurRepository.findAll();
    }

    public Optional<Joueur> getJoueurById(Long id) {
        return joueurRepository.findById(id);
    }

    public Joueur sauvegarderJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public void supprimerJoueur(Long id) {
        joueurRepository.deleteById(id);
    }
}
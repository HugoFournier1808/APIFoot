package com.foot.apifoot.service;

import com.foot.apifoot.dto.JoueurDto;
import com.foot.apifoot.entity.Joueur;

import java.util.List;
import java.util.Optional;

public interface JoueurService {
    List<Joueur> getTousLesJoueurs();
    Optional<Joueur> getJoueurById(Long id);
    Joueur save(JoueurDto joueurDto);
    Optional<Joueur> update(Long id, JoueurDto joueurDto);
    boolean delete(Long id);
}
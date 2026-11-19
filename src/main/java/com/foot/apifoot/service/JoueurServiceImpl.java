package com.foot.apifoot.service;

import com.foot.apifoot.dto.JoueurDto;
import com.foot.apifoot.entity.Joueur;
import com.foot.apifoot.repository.JoueurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.foot.apifoot.repository.EquipeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class JoueurServiceImpl implements JoueurService {

    private final JoueurRepository joueurRepository;
    private final EquipeRepository equipeRepository;

    @Override
    public List<Joueur> getTousLesJoueurs() {
        return joueurRepository.findAll();
    }

    @Override
    public Optional<Joueur> getJoueurById(Long id) {
        return joueurRepository.findById(id);
    }

    @Override
    public Joueur save(JoueurDto joueurDto) {
        return mapperEtSauvegarder(new Joueur(), joueurDto);
    }

    @Override
    public Optional<Joueur> update(Long id, JoueurDto joueurDto) {
        return joueurRepository.findById(id)
                .map(joueur -> mapperEtSauvegarder(joueur, joueurDto));
    }

    @Override
    public boolean delete(Long id) {
        if (!joueurRepository.existsById(id)) {
            return false;
        }
        joueurRepository.deleteById(id);
        return true;
    }

    private Joueur mapperEtSauvegarder(Joueur joueur, JoueurDto dto) {
        joueur.setNom(dto.getNom());
        joueur.setPrenom(dto.getPrenom());
        joueur.setPoste(dto.getPoste());
        joueur.setNumeroMaillot(dto.getNumeroMaillot());

        if (dto.getEquipeId() != null) {
            equipeRepository.findById(dto.getEquipeId()).ifPresent(joueur::setEquipe);
        }

        return joueurRepository.save(joueur);
    }
}
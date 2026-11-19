package com.foot.apifoot.service;

import com.foot.apifoot.dto.EquipeDto;
import com.foot.apifoot.entity.Equipe;
import com.foot.apifoot.repository.EquipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipeServiceImpl implements EquipeService {

    private final EquipeRepository equipeRepository;

    @Override
    public List<Equipe> getToutesLesEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Optional<Equipe> getEquipeById(Long id) {
        return equipeRepository.findById(id);
    }

    @Override
    public Equipe save(EquipeDto equipeDto) {
        return mapperEtSauvegarder(new Equipe(), equipeDto);
    }

    @Override
    public Optional<Equipe> update(Long id, EquipeDto equipeDto) {
        return equipeRepository.findById(id)
                .map(equipe -> mapperEtSauvegarder(equipe, equipeDto));
    }

    @Override
    public boolean delete(Long id) {
        if (!equipeRepository.existsById(id)) {
            return false;
        }
        equipeRepository.deleteById(id);
        return true;
    }

    private Equipe mapperEtSauvegarder(Equipe equipe, EquipeDto dto) {
        equipe.setNom(dto.getNom());
        equipe.setVille(dto.getVille());
        return equipeRepository.save(equipe);
    }
}
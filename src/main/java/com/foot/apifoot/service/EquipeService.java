package com.foot.apifoot.service;

import com.foot.apifoot.dto.EquipeDto;
import com.foot.apifoot.entity.Equipe;

import java.util.List;
import java.util.Optional;

public interface EquipeService {
    List<Equipe> getToutesLesEquipes();
    Optional<Equipe> getEquipeById(Long id);
    Equipe save(EquipeDto equipeDto);
    Optional<Equipe> update(Long id, EquipeDto equipeDto);
    boolean delete(Long id);
}
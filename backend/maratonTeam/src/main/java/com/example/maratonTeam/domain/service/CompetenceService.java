package com.example.maratonTeam.domain.service;

import com.example.maratonTeam.domain.CompetenceDomain;
import com.example.maratonTeam.domain.CompetenceGet;
import com.example.maratonTeam.domain.CompetenceRegistered;
import com.example.maratonTeam.persistence.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenceService {

    @Autowired
    private CompetenceRepository competenceRepository;

    public List<CompetenceGet> getAll(){
        return competenceRepository.getAll();
    }

    public List<CompetenceRegistered> getAllRegistration(int idTeam){
        return competenceRepository.getAllRegistration(idTeam);
    }

    public Optional<CompetenceGet> getCompetence(int idCompetence){
        return competenceRepository.getCompetence(idCompetence);
    }

    public CompetenceDomain save(CompetenceDomain competenceDomain){
        return competenceRepository.save(competenceDomain);
    }

    public boolean delete(int idCompetence){
        return getCompetence(idCompetence).map(competenceDomain -> {
            competenceRepository.delete(idCompetence);
            return true;
        }).orElse(false);
    }
}

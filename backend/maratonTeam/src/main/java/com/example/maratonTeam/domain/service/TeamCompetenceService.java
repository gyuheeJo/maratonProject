package com.example.maratonTeam.domain.service;

import com.example.maratonTeam.domain.TeamCompetenceDomain;
import com.example.maratonTeam.persistence.TeamCompetenceRepository;
import com.example.maratonTeam.persistence.entity.TeamCompetence;
import com.example.maratonTeam.persistence.entity.TeamCompetencePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamCompetenceService {

    @Autowired
    private TeamCompetenceRepository teamCompetenceRepository;

    public void save(TeamCompetenceDomain teamCompetence){
        teamCompetenceRepository.save(teamCompetence);
    }

    public boolean delete(TeamCompetencePK id){
        return teamCompetenceRepository.getTeamComptence(id).map(teamCompetence -> {
            teamCompetenceRepository.delete(id);
            return true;
        }).orElse(false);
    }

}

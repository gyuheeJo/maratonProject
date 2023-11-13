package com.example.maratonTeam.persistence;

import com.example.maratonTeam.domain.TeamCompetenceDomain;
import com.example.maratonTeam.persistence.crud.TeamCompetenceCrudRepository;
import com.example.maratonTeam.persistence.entity.TeamCompetence;
import com.example.maratonTeam.persistence.entity.TeamCompetencePK;
import com.example.maratonTeam.persistence.mapper.TeamCompetenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeamCompetenceRepository {
    
    @Autowired
    private TeamCompetenceCrudRepository teamCompetenceCrudRepository;
    @Autowired
    private TeamCompetenceMapper teamCompetenceMapper;

    public Optional<TeamCompetenceDomain> getTeamComptence(TeamCompetencePK id){
        return teamCompetenceCrudRepository.findById(id)
                .map(teamCompetence -> teamCompetenceMapper.toTeamCompetenceDomain(teamCompetence));
    }

    public void save(TeamCompetenceDomain t){


        teamCompetenceCrudRepository.save(t.getTeam(), t.getCompetence());

    }

    public void delete(TeamCompetencePK id){
        teamCompetenceCrudRepository.deleteById(id);
    }

    public void deleteByCompetences(List<Integer> idsCompetence){
        idsCompetence.forEach(idCompetence -> {
            teamCompetenceCrudRepository.deleteByIdCompetence(idCompetence);
        });
    }
}

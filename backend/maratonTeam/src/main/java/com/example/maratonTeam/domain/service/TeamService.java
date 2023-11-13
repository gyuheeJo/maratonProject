package com.example.maratonTeam.domain.service;

import com.example.maratonTeam.domain.TeamDomain;
import com.example.maratonTeam.domain.TeamGet;
import com.example.maratonTeam.persistence.CompetenceRepository;
import com.example.maratonTeam.persistence.TeamCompetenceRepository;
import com.example.maratonTeam.persistence.TeamRepository;
import com.example.maratonTeam.persistence.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private TeamCompetenceRepository teamCompetenceRepository;

    public List<TeamGet> getAll(){
        return teamRepository.getAll();
    }

    public Optional<TeamGet> getTeam(int idTeam){
        return teamRepository.getTeam(idTeam);
    }

    public Boolean isTeamRegistered(int idTeam){
        List<Integer> ids = competenceRepository.getAllValidityExpiredId();
        teamCompetenceRepository.deleteByCompetences(ids);
        return getTeam(idTeam).map(team -> {
            return teamRepository.isTeamRegistered(team);
        }).orElse(null);
    }

    public Integer save(TeamDomain teamDomain){
        return teamRepository.save(teamDomain);
    }

    public boolean delete(int idTeam){
        return getTeam(idTeam).map(team -> {
            teamRepository.delete(idTeam);
            return true;
        }).orElse(false);
    }
}

package com.example.maratonTeam.persistence;

import com.example.maratonTeam.domain.TeamDomain;
import com.example.maratonTeam.domain.TeamGet;
import com.example.maratonTeam.persistence.crud.TeamCrudRepository;
import com.example.maratonTeam.persistence.entity.Team;
import com.example.maratonTeam.persistence.mapper.TeamCreateMapper;
import com.example.maratonTeam.persistence.mapper.TeamGetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeamRepository {

    @Autowired
    private TeamCrudRepository teamCrudRepository;

    @Autowired
    private TeamCreateMapper mapper;
    @Autowired
    private TeamGetMapper teamGetMapper;

    public List<TeamGet> getAll(){
        return teamGetMapper.toTeamGets((List<Team>) teamCrudRepository.findAll());
    }

    public Optional<TeamGet> getTeam(int idTeam){
        return teamCrudRepository.findById(idTeam)
                .map(team -> teamGetMapper.toTeamGet(team));
    }

    public int teamSize(int idTeam){
        return teamCrudRepository.findById(idTeam).map(team -> {
            if (team.getParticipants() != null){
                return team.getParticipants().size();
            }return 0;
        }).orElse(-1);
    }
    public boolean isTeamRegistered(TeamGet team){
        return !team.getTeamCompetences().isEmpty();
    }

    public Integer save(TeamDomain teamDomain){
        return teamCrudRepository.save(mapper.toTeam(teamDomain)).getIdTeam();
    }

    public void delete(int idTeam){
        teamCrudRepository.deleteById(idTeam);
    }
}

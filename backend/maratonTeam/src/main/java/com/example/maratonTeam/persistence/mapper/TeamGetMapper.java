package com.example.maratonTeam.persistence.mapper;

import com.example.maratonTeam.domain.TeamGet;
import com.example.maratonTeam.persistence.entity.Team;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeamCompetenceMapper.class, ParticipantDomainMapper.class})
public interface TeamGetMapper {
    TeamGet toTeamGet(Team team);
    List<TeamGet> toTeamGets(List<Team> teams);
    @InheritInverseConfiguration
    Team toTeam(TeamGet teamGet);

}

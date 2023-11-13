package com.example.maratonTeam.persistence.mapper;

import com.example.maratonTeam.domain.TeamCompetenceDomain;
import com.example.maratonTeam.persistence.entity.TeamCompetence;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeamGetMapper.class, CompetenceGetMapper.class})
public interface TeamCompetenceMapper {

    @Mappings({
            @Mapping(source = "id.team", target = "team"),
            @Mapping(source = "id.competence", target = "competence")
    })
    TeamCompetenceDomain toTeamCompetenceDomain(TeamCompetence teamCompetence);
    List<TeamCompetenceDomain> toTeamCompetenceDomains(List<TeamCompetence> teamCompetences);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "team", target = "id.team"),
            @Mapping(source = "competence", target = "id.competence"),
            @Mapping(target = "team", ignore = true),
            @Mapping(target = "competence", ignore = true),
    })
    TeamCompetence toTeamCompetence(TeamCompetenceDomain teamCompetenceDomain);

}

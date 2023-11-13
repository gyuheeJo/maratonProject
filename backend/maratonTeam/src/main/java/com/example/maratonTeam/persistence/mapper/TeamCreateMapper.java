package com.example.maratonTeam.persistence.mapper;

import com.example.maratonTeam.domain.TeamDomain;
import com.example.maratonTeam.persistence.entity.Team;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TeamCreateMapper {

    TeamDomain toTeamCreate(Team team);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "idTeam", ignore = true),
            @Mapping(target = "participants", ignore = true),
            @Mapping(target = "teamCompetences", ignore = true),
    })
    Team toTeam(TeamDomain teamDomain);

}

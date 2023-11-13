package com.example.maratonTeam.persistence.mapper;

import com.example.maratonTeam.domain.CompetenceDomain;
import com.example.maratonTeam.persistence.entity.Competence;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {TeamCompetenceMapper.class})
public interface CompetenceCreateMapper {

    CompetenceDomain toCompetenceDomain(Competence competence);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "teamCompetences", ignore = true),
            @Mapping(target = "idCompetence", ignore = true)

    })
    Competence toCompetence(CompetenceDomain competenceDomain);

}

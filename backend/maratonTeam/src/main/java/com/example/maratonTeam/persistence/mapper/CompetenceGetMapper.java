package com.example.maratonTeam.persistence.mapper;

import com.example.maratonTeam.domain.CompetenceDomain;
import com.example.maratonTeam.domain.CompetenceGet;
import com.example.maratonTeam.persistence.entity.Competence;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeamCompetenceMapper.class})
public interface CompetenceGetMapper {

    @Mapping(target = "name", ignore = true)
    CompetenceGet toCompetenceGet(Competence competence);
    List<CompetenceGet> toCompetenceGets(List<Competence> competences);

    @InheritInverseConfiguration
    @Mapping(target = "idCompetence", ignore = true)
    Competence toCompetence(CompetenceGet competenceGet);

}

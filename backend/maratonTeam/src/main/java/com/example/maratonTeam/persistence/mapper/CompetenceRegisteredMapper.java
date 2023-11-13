package com.example.maratonTeam.persistence.mapper;

import com.example.maratonTeam.domain.CompetenceRegistered;
import com.example.maratonTeam.persistence.entity.Competence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeamCompetenceMapper.class})
public interface CompetenceRegisteredMapper {
    @Mappings({
            @Mapping(target = "name", ignore = true),
            @Mapping(target = "registered", ignore = true)
    })
    CompetenceRegistered toCompetenceRegistered(Competence competence);
    List<CompetenceRegistered> toCompetenceRegistereds(List<Competence> competences);
}

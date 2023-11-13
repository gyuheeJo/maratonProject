package com.example.maratonTeam.persistence.mapper;

import com.example.maratonTeam.domain.ParticipantDomain;
import com.example.maratonTeam.persistence.entity.Participant;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ParticipantDomainMapper {

    ParticipantDomain toParticipantDomain(Participant participant);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "idTeam", ignore = true),
            @Mapping(target = "team", ignore = true),
    })
    Participant toParticipant(ParticipantDomain participantDomain);
}

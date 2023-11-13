package com.example.maratonTeam.persistence.mapper;


import com.example.maratonTeam.domain.ParticipantGet;
import com.example.maratonTeam.persistence.entity.Participant;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeamGetMapper.class})
public interface ParticipantGetMapper {

    ParticipantGet toParticipantGet(Participant participant);
    List<ParticipantGet> toParticipantGets(List<Participant> participants);

    @InheritInverseConfiguration
    Participant toParticipant(ParticipantGet participantGet);
}

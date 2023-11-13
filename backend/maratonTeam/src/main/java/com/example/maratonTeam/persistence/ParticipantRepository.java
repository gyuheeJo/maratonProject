package com.example.maratonTeam.persistence;

import com.example.maratonTeam.domain.ParticipantDomain;
import com.example.maratonTeam.domain.ParticipantGet;
import com.example.maratonTeam.persistence.crud.ParticipantCrudRepository;
import com.example.maratonTeam.persistence.entity.Participant;
import com.example.maratonTeam.persistence.mapper.ParticipantDomainMapper;
import com.example.maratonTeam.persistence.mapper.ParticipantGetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ParticipantRepository {

    @Autowired
    private ParticipantCrudRepository participantCrudRepository;

    @Autowired
    private ParticipantDomainMapper participantDomainMapper;
    @Autowired
    private ParticipantGetMapper participantGetMapper;

    public List<ParticipantGet> getAll(){
        return participantGetMapper.toParticipantGets((List<Participant>) participantCrudRepository.findAll());
    }

    public Optional<ParticipantGet> getParticipant(String idParticipant){
        return participantCrudRepository.findById(idParticipant)
                .map(participant -> participantGetMapper.toParticipantGet(participant));
    }

    public Optional<List<ParticipantGet>> getByTeam(int idTeam){
        return participantCrudRepository.findByIdTeam(idTeam)
                .map(participants -> participantGetMapper.toParticipantGets(participants));
    }

    public boolean setIdTeamNull(String idParticipant){
        return participantCrudRepository.findById(idParticipant).map(participant -> {
            ParticipantDomain participantDomain = participantDomainMapper.toParticipantDomain(participant);
            participantCrudRepository.save(participantDomainMapper.toParticipant(participantDomain));
            return true;
        }).orElse(false);
    }
    public void updateIdTeam(ParticipantGet participant,Integer newIdTeam){

        participant.setIdTeam(newIdTeam);
        participantCrudRepository.save(participantGetMapper.toParticipant(participant));

    }

    public ParticipantDomain save(ParticipantDomain participantDomain){
        return participantDomainMapper.toParticipantDomain(
                participantCrudRepository.save(participantDomainMapper.toParticipant(participantDomain))
        );
    }

    public void delete(String idParticipant){
        participantCrudRepository.deleteById(idParticipant);
    }
}
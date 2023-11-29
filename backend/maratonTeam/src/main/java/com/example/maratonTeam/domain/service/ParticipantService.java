package com.example.maratonTeam.domain.service;

import com.example.maratonTeam.domain.ParticipantDomain;
import com.example.maratonTeam.domain.ParticipantGet;
import com.example.maratonTeam.persistence.ParticipantRepository;
import com.example.maratonTeam.persistence.TeamRepository;
import com.example.maratonTeam.persistence.entity.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private TeamRepository teamRepository;

    public List<ParticipantGet> getAll(){
        return participantRepository.getAll();
    }

    public Optional<ParticipantGet> getParticipant(String idParticipant){
        return participantRepository.getParticipant(idParticipant);
    }

    public Optional<List<ParticipantGet>> getByTeam(int idTeam){
        return participantRepository.getByTeam(idTeam);
    }

    public boolean leaveTeam(String idParticipant){
        int idTeam = getParticipant(idParticipant).get().getIdTeam();
        int teamSize = teamRepository.teamSize(idTeam);
        boolean b = participantRepository.setIdTeamNull(idParticipant);
        if (teamSize == 1){
            teamRepository.delete(idTeam);
        }
        return b;
    }
    public boolean updateIdTeam(String idParticipant, Integer idTeam){
        int teamSize = teamRepository.teamSize(idTeam);
        return getParticipant(idParticipant).map(participant -> {
            if (participant.getIdTeam() == null && -1 < teamSize && teamSize < 3){
                participantRepository.updateIdTeam(participant, idTeam);
                return true;
            }
            return false;
        }).orElse(false);
    }

    public ParticipantDomain save(ParticipantDomain participantDomain){
        return participantRepository.save(participantDomain);
    }

    public boolean delete(String idParticipant){
        return getParticipant(idParticipant).map(participant -> {
            participantRepository.delete(idParticipant);
            return true;
        }).orElse(false);
    }
}

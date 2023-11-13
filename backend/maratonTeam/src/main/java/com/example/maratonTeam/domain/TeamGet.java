package com.example.maratonTeam.domain;

import java.util.List;

public class TeamGet extends TeamDomain{

    private Integer idTeam;

    private List<ParticipantDomain> participants;
    private List<TeamCompetenceDomain> teamCompetences;

    public List<ParticipantDomain> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDomain> participants) {
        this.participants = participants;
    }

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }

    public List<TeamCompetenceDomain> getTeamCompetences() {
        return teamCompetences;
    }

    public void setTeamCompetences(List<TeamCompetenceDomain> teamCompetences) {
        this.teamCompetences = teamCompetences;
    }
}

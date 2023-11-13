package com.example.maratonTeam.domain;

public class ParticipantGet extends ParticipantDomain{

    private Integer idTeam;
    private TeamGet team;

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }

    public TeamGet getTeam() {
        return team;
    }

    public void setTeam(TeamGet team) {
        this.team = team;
    }
}

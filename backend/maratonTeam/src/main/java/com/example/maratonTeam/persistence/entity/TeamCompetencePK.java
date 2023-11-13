package com.example.maratonTeam.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class TeamCompetencePK implements Serializable {

    @Column(name = "id_team")
    private Integer team;
    @Column(name = "id_competence")
    private Integer competence;

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public Integer getCompetence() {
        return competence;
    }

    public void setCompetence(Integer competence) {
        this.competence = competence;
    }
}

package com.example.maratonTeam.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "team_competence")
public class TeamCompetence {

    @EmbeddedId
    private TeamCompetencePK id;

    @ManyToOne
    @MapsId("team")
    @JoinColumn(name = "id_team", insertable = false, updatable = false)
    private Team team;

    @ManyToOne
    @MapsId("competence")
    @JoinColumn(name = "id_competence", insertable = false, updatable = false)
    private Competence competence;

    public TeamCompetencePK getId() {
        return id;
    }

    public void setId(TeamCompetencePK id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
}

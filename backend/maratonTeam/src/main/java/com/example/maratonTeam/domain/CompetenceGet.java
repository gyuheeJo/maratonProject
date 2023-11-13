package com.example.maratonTeam.domain;

import java.util.List;

public class CompetenceGet extends CompetenceDomain{

    protected Integer idCompetence;

    protected String name;

    protected List<TeamCompetenceDomain> teamCompetences;

    public List<TeamCompetenceDomain> getTeamCompetences() {
        return teamCompetences;
    }

    public void setTeamCompetences(List<TeamCompetenceDomain> teamCompetences) {
        this.teamCompetences = teamCompetences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Integer idCompetence) {
        this.idCompetence = idCompetence;
    }
}

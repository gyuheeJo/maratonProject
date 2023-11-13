package com.example.maratonTeam.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team")
    private Integer idTeam;
    private String name;
    private String category;
    @OneToMany(mappedBy = "team")
    private List<Participant> participants;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.ALL})
    private List<TeamCompetence> teamCompetences;

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<TeamCompetence> getTeamCompetences() {
        return teamCompetences;
    }

    public void setTeamCompetences(List<TeamCompetence> teamCompetences) {
        this.teamCompetences = teamCompetences;
    }
}

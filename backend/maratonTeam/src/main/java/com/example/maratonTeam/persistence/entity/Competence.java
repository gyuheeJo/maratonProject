package com.example.maratonTeam.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "competences")
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competence")
    protected Integer idCompetence;
    protected String Category;
    protected LocalDateTime date;
    protected Integer period;
    protected LocalDateTime validity;
    @OneToMany(mappedBy = "competence", cascade = {CascadeType.ALL})
    private List<TeamCompetence> teamCompetences;

    public Integer getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Integer idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public LocalDateTime getValidity() {
        return validity;
    }

    public void setValidity(LocalDateTime validity) {
        this.validity = validity;
    }

    public List<TeamCompetence> getTeamCompetences() {
        return teamCompetences;
    }

    public void setTeamCompetences(List<TeamCompetence> teamCompetences) {
        this.teamCompetences = teamCompetences;
    }
}

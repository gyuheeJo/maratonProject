package com.example.maratonTeam.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "participants")
public class Participant {

    @Id
    @Column(name = "id_participant")
    private String idParticipant;
    private String name;
    private Integer codigo;
    private String course;
    @Column(name = "id_team")
    private Integer idTeam;
    @ManyToOne
    @JoinColumn(name = "id_team", insertable = false, updatable = false)
    private Team team;

    public String getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(String idParticipant) {
        this.idParticipant = idParticipant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

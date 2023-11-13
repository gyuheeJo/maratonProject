package com.example.maratonTeam.domain;

public class ParticipantDomain {

    protected String idParticipant;
    protected String name;
    protected Integer codigo;
    protected String course;

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
}

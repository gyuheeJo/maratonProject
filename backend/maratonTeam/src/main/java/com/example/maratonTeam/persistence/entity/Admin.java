package com.example.maratonTeam.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @Column(name = "id_admin")
    private String idAdmin;
    private String name;

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

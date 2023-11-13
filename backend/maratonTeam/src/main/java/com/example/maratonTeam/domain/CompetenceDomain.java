package com.example.maratonTeam.domain;

import com.example.maratonTeam.persistence.entity.TeamCompetence;
import java.time.LocalDateTime;
import java.util.List;

public class CompetenceDomain {
    protected String Category;
    protected LocalDateTime date;
    protected Integer period;
    protected LocalDateTime validity;


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
}

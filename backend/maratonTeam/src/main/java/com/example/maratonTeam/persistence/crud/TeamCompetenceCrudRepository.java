package com.example.maratonTeam.persistence.crud;

import com.example.maratonTeam.persistence.entity.TeamCompetence;
import com.example.maratonTeam.persistence.entity.TeamCompetencePK;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeamCompetenceCrudRepository extends CrudRepository<TeamCompetence, TeamCompetencePK> {
    /*
    Optional<List<TeamCompetence>> findByIdTeam(int team);
    void deleteAllByIdTeam(int team);*/
    @Transactional
    public void deleteByIdCompetence(int idCompetence);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO team_competence VALUES (?, ?)", nativeQuery = true)
    public void save(Integer idTeam, Integer idCompetence);
}

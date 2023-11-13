package com.example.maratonTeam.persistence.crud;

import com.example.maratonTeam.persistence.entity.Competence;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompetenceCrudRepository extends CrudRepository <Competence, Integer>{

    @Query(value = "SELECT id_competence FROM competences WHERE validity < now()", nativeQuery = true)
    public List<Integer> getAllValidityExpiredId();

    @Query(value = "SELECT * FROM competences WHERE date > now()", nativeQuery = true)
    public List<Competence> getAllNotExpired();
}

package com.example.maratonTeam.persistence.crud;

import com.example.maratonTeam.persistence.entity.Participant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipantCrudRepository extends CrudRepository <Participant, String>{
    Optional<List<Participant>> findByIdTeam(int idTeam);

}

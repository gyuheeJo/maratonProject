package com.example.maratonTeam.persistence.crud;

import com.example.maratonTeam.persistence.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamCrudRepository extends CrudRepository <Team, Integer> {


}

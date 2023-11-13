package com.example.maratonTeam.persistence.crud;

import com.example.maratonTeam.persistence.entity.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<Admin, String> {
}

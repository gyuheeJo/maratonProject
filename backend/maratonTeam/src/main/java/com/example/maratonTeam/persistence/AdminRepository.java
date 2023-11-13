package com.example.maratonTeam.persistence;

import com.example.maratonTeam.domain.AdminDomain;
import com.example.maratonTeam.persistence.crud.AdminCrudRepository;
import com.example.maratonTeam.persistence.entity.Admin;
import com.example.maratonTeam.persistence.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;
    @Autowired
    private AdminMapper mapper;
    public Optional<AdminDomain> getAdmin(String idAdmin){
        return adminCrudRepository.findById(idAdmin)
                .map(admin -> mapper.toAdminDomain(admin));
    }

}

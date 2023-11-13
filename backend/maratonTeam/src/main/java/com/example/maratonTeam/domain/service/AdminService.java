package com.example.maratonTeam.domain.service;

import com.example.maratonTeam.domain.AdminDomain;
import com.example.maratonTeam.persistence.AdminRepository;
import com.example.maratonTeam.persistence.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Optional<AdminDomain> getAdmin(String idAdmin){
        return adminRepository.getAdmin(idAdmin);
    }

}

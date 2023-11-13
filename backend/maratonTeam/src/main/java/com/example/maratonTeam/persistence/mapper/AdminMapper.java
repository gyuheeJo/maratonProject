package com.example.maratonTeam.persistence.mapper;

import com.example.maratonTeam.domain.AdminDomain;
import com.example.maratonTeam.persistence.entity.Admin;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminDomain toAdminDomain(Admin admin);

}

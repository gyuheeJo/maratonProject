package com.example.maratonTeam.web.controller;

import com.example.maratonTeam.domain.AdminDomain;
import com.example.maratonTeam.domain.service.AdminService;
import com.example.maratonTeam.persistence.entity.Admin;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("{id}")
    @Operation(summary = "get by admin id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Admin"),
            @ApiResponse(responseCode = "404", description = "Not Found Admin", content = @Content)
    })
    public ResponseEntity<AdminDomain> getAdmin(@PathVariable("id") String idAdmin){
        return adminService.getAdmin(idAdmin)
                .map(admin -> new ResponseEntity<>(admin, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

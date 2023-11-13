package com.example.maratonTeam.web.controller;

import com.example.maratonTeam.domain.TeamCompetenceDomain;
import com.example.maratonTeam.domain.service.TeamCompetenceService;
import com.example.maratonTeam.persistence.entity.TeamCompetence;
import com.example.maratonTeam.persistence.entity.TeamCompetencePK;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teamcompetence")
public class TeamCompetenceController {

    @Autowired
    private TeamCompetenceService teamCompetenceService;

    @PostMapping("/save")
    @Operation(summary = "create registration team-competence")
    @ApiResponse(responseCode = "201", description = "create registration")
    public ResponseEntity save(@RequestBody TeamCompetenceDomain teamCompetence){
        teamCompetenceService.save(teamCompetence);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "delete a registration team-competence")
    @ApiResponse(responseCode = "200", description = "deleted registration")
    public ResponseEntity delete(@RequestBody TeamCompetencePK teamCompetencePK){
        if (teamCompetenceService.delete(teamCompetencePK)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}

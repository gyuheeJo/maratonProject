package com.example.maratonTeam.web.controller;

import com.example.maratonTeam.domain.CompetenceDomain;
import com.example.maratonTeam.domain.CompetenceGet;
import com.example.maratonTeam.domain.CompetenceRegistered;
import com.example.maratonTeam.domain.service.CompetenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competence")
public class CompetenceController {

    @Autowired
    private CompetenceService competenceService;

    @GetMapping("/all")
    @Operation(summary = "get all competences")
    @ApiResponse(responseCode = "200", description = "Obtained all competences")
    public ResponseEntity<List<CompetenceGet>> getAll(){
        return new ResponseEntity<>(competenceService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(summary = "get a Competence")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtained competence"),
            @ApiResponse(responseCode = "404", description = "competence not found")
    })
    public ResponseEntity<CompetenceGet> getCompetence(@PathVariable("id") int idCompetence){
        return competenceService.getCompetence(idCompetence).map(competenceDomain -> new ResponseEntity<>(competenceDomain, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/registration/{idTeam}")
    @Operation(summary = "get all competences and clasificate them whether each competences belong to a specific team or not and discard by competence date-time")
    @ApiResponse(responseCode = "200", description = "Obtained competences clasificated")
    public ResponseEntity<List<CompetenceRegistered>> getAllRegistration(@PathVariable("idTeam") int idTeam){
        return new ResponseEntity<>(competenceService.getAllRegistration(idTeam), HttpStatus.OK);
    }

    @PostMapping("/save")
    @Operation(summary = "save competence")
    @ApiResponse(responseCode = "201", description = "competence created")
    public ResponseEntity<CompetenceDomain> save(@RequestBody CompetenceDomain competenceDomain){
        return new ResponseEntity<>(competenceService.save(competenceDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "delete competence")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "competence deleted"),
            @ApiResponse(responseCode = "404", description = "competence not found")
    })
    public ResponseEntity delete(@PathVariable("id") int idCompetence){
        if (competenceService.delete(idCompetence)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

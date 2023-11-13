package com.example.maratonTeam.web.controller;

import com.example.maratonTeam.domain.TeamDomain;
import com.example.maratonTeam.domain.TeamGet;
import com.example.maratonTeam.domain.service.ParticipantService;
import com.example.maratonTeam.domain.service.TeamService;
import com.example.maratonTeam.persistence.entity.Team;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private ParticipantService participantService;

    @GetMapping("/all")
    @Operation(summary = "get all teams")
    @ApiResponse(responseCode = "200", description = "Obtained all teams")
    public ResponseEntity<List<TeamGet>> getAll(){
        return new ResponseEntity<>(teamService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(summary = "get by team id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtained team"),
            @ApiResponse(responseCode = "404", description = "Not Found team", content = @Content)
    })
    public ResponseEntity<TeamGet> getTeam(@PathVariable("id") int idTeam){
        return teamService.getTeam(idTeam).map(team -> new ResponseEntity<>(team, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/registeredornot/{id}")
    @Operation(summary = "is the team registered in one or more competence?")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "true or false"),
            @ApiResponse(responseCode = "404", description = "team not found", content = @Content),
    })
    public ResponseEntity<Boolean> isTeamRegistered(@PathVariable("id") int idTeam){
        Boolean b = teamService.isTeamRegistered(idTeam);
        if (b == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @PostMapping("/save/{idParticipant}")
    @Operation(summary = "create team")
    @ApiResponse(responseCode = "201", description = "team created")
    public ResponseEntity save(@RequestBody TeamDomain teamDomain, @PathVariable("idParticipant") String idParticipant){
        Integer idTeam = teamService.save(teamDomain);
        if(participantService.updateIdTeam(idParticipant, idTeam)){
            return new ResponseEntity(HttpStatus.CREATED);
        };
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete team")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "deleted team"),
            @ApiResponse(responseCode = "404", description = "Not Found team", content = @Content),
    })
    public ResponseEntity delete(@PathVariable("id") int idTeam){
        if (teamService.delete(idTeam)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}

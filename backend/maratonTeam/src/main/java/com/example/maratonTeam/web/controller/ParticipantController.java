package com.example.maratonTeam.web.controller;

import com.example.maratonTeam.domain.ParticipantDomain;
import com.example.maratonTeam.domain.ParticipantGet;
import com.example.maratonTeam.domain.service.ParticipantService;
import com.example.maratonTeam.persistence.entity.Participant;
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
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/all")
    @Operation(summary = "get all participants")
    @ApiResponse(responseCode = "200", description = "Obtained all participants")
    public ResponseEntity<List<ParticipantGet>> getAll(){
        return new ResponseEntity<>(participantService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(summary = "get by participant id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtained participant"),
            @ApiResponse(responseCode = "404", description = "Not Found participant", content = @Content)
    })
    public ResponseEntity<ParticipantGet> getParticipant(@PathVariable("id") String idParticipant){
        return participantService.getParticipant(idParticipant)
                .map(participant -> new ResponseEntity<>(participant, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/team/{id}")
    @Operation(summary = "get participant by team id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtained participants"),
            @ApiResponse(responseCode = "404", description = "Not Found participants", content = @Content)
    })
    public ResponseEntity<List<ParticipantGet>> getByTeam(@PathVariable("id") int idTeam){
        return participantService.getByTeam(idTeam)
                .map(participant -> new ResponseEntity<>(participant, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/leaveteam/{id}")
    @Operation(summary = "leave current team")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "let the team"),
            @ApiResponse(responseCode = "404", description = "Not Found participant", content = @Content)
    })
    public ResponseEntity leaveTeam(@PathVariable("id") String idParticipant){
        if(participantService.leaveTeam(idParticipant)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}/{idTeam}")
    @Operation(summary = "update team id of a participant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "updated team id"),
            @ApiResponse(responseCode = "404", description = "Not Found participant, could be:  didn't found team or participant, team is already complete, participant already has a team", content = @Content),
    })
    public ResponseEntity updateIdTeam(@PathVariable("id") String idParticipant, @PathVariable("idTeam") int idTeam){

        if(participantService.updateIdTeam(idParticipant, idTeam)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/save")
    @Operation(summary = "create a participant")
    @ApiResponse(responseCode = "201", description = "participant created")
    public ResponseEntity<ParticipantDomain> save(@RequestBody ParticipantDomain participantDomain){
        return new ResponseEntity<>(participantService.save(participantDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete a participant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "deleted participant"),
            @ApiResponse(responseCode = "404", description = "Not Found participant", content = @Content),
    })
    public ResponseEntity delete(@PathVariable("id") String idParticipant){
        if (participantService.delete(idParticipant)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}

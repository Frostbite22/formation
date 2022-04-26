package com.sb.formation.controller.user;

import com.sb.formation.entities.Participant;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.ParticipantServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@CrossOrigin("*")
@RequestMapping("/participant")
@PreAuthorize("hasRole('ROLE_USER')")
public class ParticipantController {
    @Autowired
    private ParticipantServiceImpl participantService;

    @GetMapping
    @ApiOperation(value="Trouver tous les participants", notes="find participants")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="Participants trouvés")
    })
    public List<Participant> findAll() {
        return participantService.findAll();
    }

    @PostMapping
    @ApiOperation(value="Enregistrer un participant", notes="save participant")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="participant enregistré")
    })
    public MessageResponse save(@RequestBody Participant participant) {
        return participantService.save(participant);
    }

    @PutMapping
    @ApiOperation(value="mettre à jour un participant", notes="update participant")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="participant mis à jour")
    })
    public MessageResponse update(@RequestBody Participant participant) {
        return participantService.update(participant);
    }

    @GetMapping("/{code}")
    @ApiOperation(value="trouver un participant par id", notes="find participant by id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="participant trouvé")
    })
    public Participant findById(@PathVariable("code") Long id) {
        return participantService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="supprimé un participant", notes="delete participant")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="participant supprimé")
    })
    public MessageResponse delete(@PathVariable Long id) {
        return participantService.delete(id);
    }
}

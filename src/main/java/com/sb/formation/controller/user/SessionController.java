package com.sb.formation.controller.user;

import com.sb.formation.entities.Session;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.SessionServiceImpl;

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
@RequestMapping("/session")
@PreAuthorize("hasRole('ROLE_USER')")
public class SessionController {
    @Autowired
    private SessionServiceImpl sessionServiceImpl;

    @GetMapping
    @ApiOperation(value="Trouver tout les sessions", notes="trouver sessions")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="sessions trouvés")
    })
    public List<Session> findAll() {
        return sessionServiceImpl.findAll();
    }

    @PostMapping
    @ApiOperation(value="Enregistrer une sessions", notes="save sessions")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="Sessions enregistrées")
    })
    public MessageResponse save(@RequestBody Session session) {
        return sessionServiceImpl.save(session);
    }

    @PutMapping
    @ApiOperation(value="Mettre à jour une session", notes="update session")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="session mise à jour")
    })
    public MessageResponse update(@RequestBody Session session) {
        return sessionServiceImpl.update(session);
    }

    @GetMapping("/{code}")
    @ApiOperation(value="Trouver une session par id", notes="find session with id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="session trouvée")
    })
    public Session findById(@PathVariable("code") Long id) {
        return sessionServiceImpl.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Supprimer session par id ", notes="delete session")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="session supprimée")
    })
    public MessageResponse delete(@PathVariable Long id) {
        return sessionServiceImpl.delete(id);
    }
}

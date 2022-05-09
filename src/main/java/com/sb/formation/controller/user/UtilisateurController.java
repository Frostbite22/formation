package com.sb.formation.controller.user;

import com.sb.formation.entities.Utilisateur;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.UtilisateurServiceImpl;

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
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurServiceImpl utilisateurServiceImpl;

    @GetMapping
    @PutMapping
    @ApiOperation(value="Trouver tout les utilisateur", notes="trouver utilisateurs")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="Utilisateurs trouvés")
    })
    public List<Utilisateur> findAll() {
        return utilisateurServiceImpl.findAll();
    }

    @PostMapping
    @ApiOperation(value="Enregistrer un utilisateur", notes="save user")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="utilisateur enregistrer")
    })
    public MessageResponse save(@RequestBody Utilisateur utilisateur) {
        return utilisateurServiceImpl.save(utilisateur);
    }

    @PutMapping
    @ApiOperation(value="Mettre à jour utilisateur", notes="mise à jour user")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="utilisateur mis à jour")
    })
    public MessageResponse update(@RequestBody Utilisateur utilisateur) {
        return utilisateurServiceImpl.update(utilisateur);
    }

    @GetMapping("/{code}")
    @ApiOperation(value="Trouver utilisateur par id", notes="trouver user par id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="Utilisateur trouvé")
    })
    public Utilisateur findById(@PathVariable("code") Long code) {
        return utilisateurServiceImpl.findByCode(code);
    }

    @DeleteMapping("/{code}")
    @ApiOperation(value="supprimer un utilisateur", notes="supprimer utilisateur")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="utilisateur supprimé")
    })
    public MessageResponse delete(@PathVariable Long code) {
        return utilisateurServiceImpl.delete(code);
    }
}

package com.sb.formation.controller.admin;

import com.sb.formation.entities.Profil;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.ProfilServiceImpl;

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
@RequestMapping("/profil")
@PreAuthorize("hasRole('ROLE_USER')")
public class ProfilController {
    @Autowired
    private ProfilServiceImpl profilService;

    @GetMapping
    @ApiOperation(value="Trouver tous les profils", notes="trouver profils")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="profils trouvés")
    })
    public List<Profil> findAll() {
        return profilService.findAll();
    }

    @PostMapping
    @ApiOperation(value="Enregistrer un profile", notes="save profile")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="profil enregistré")
    })
    public MessageResponse save(@RequestBody Profil profil) {
        return profilService.save(profil);
    }

    @PutMapping
    @ApiOperation(value="Mettre à jour un profil", notes="update profil")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="profil mis à jour")
    })
    public MessageResponse update(@RequestBody Profil profil) {
        return profilService.update(profil);
    }

    @GetMapping("/{code}")
    @ApiOperation(value="Trouver un profil par id", notes="trouver profil par id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="profil trouvé")
    })
    public Profil findById(@PathVariable("code") Long id) {
        return profilService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="supprimer un profil par id", notes="supprimé profil par id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="profil supprimé")
    })
    public MessageResponse delete(@PathVariable Long id) {
        return profilService.delete(id);
    }
}

package com.sb.formation.controller.admin;

import com.sb.formation.entities.Pays;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.PaysServiceImpl;

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
@RequestMapping("/pays")
@PreAuthorize("hasRole('ROLE_USER')")
public class PaysController {
    @Autowired
    private PaysServiceImpl paysServiceImpl;

    @GetMapping
    @ApiOperation(value="Trouver tous les pays", notes="trouver pays")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="pays trouvés")
    })
    public List<Pays> findAll() {
        return paysServiceImpl.findAll();
    }

    @PostMapping
    @ApiOperation(value="Enregistrer un pays", notes="save pays")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="pays enregistré")
    })
    public MessageResponse save(@RequestBody Pays pays) {
        return paysServiceImpl.save(pays);
    }

    @PutMapping
    @ApiOperation(value="mettre à jour un pays", notes="update pays")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="pays mis à jour")
    })
    public MessageResponse update(@RequestBody Pays pays) {
        return paysServiceImpl.update(pays);
    }

    @GetMapping("/{code}")
    @ApiOperation(value="trouver un pays par id", notes="find pays par id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="pays trouvé")
    })
    public Pays findById(@PathVariable("code") Long id) {
        return paysServiceImpl.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="supprimé un pays par id", notes="delete pays par id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="pays supprimé")
    })
    public MessageResponse delete(@PathVariable Long id) {
        return paysServiceImpl.delete(id);
    }
}

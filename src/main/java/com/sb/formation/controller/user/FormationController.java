package com.sb.formation.controller.user;

import com.sb.formation.entities.Formation;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.FormationServiceImpl;

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
@RequestMapping("/formation")
@PreAuthorize("hasRole('ROLE_USER')")
public class FormationController {
    @Autowired
    private FormationServiceImpl formationService;

    @GetMapping
    @ApiOperation(value="Trouver tous les formation", notes="find formations")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="Tous les formations sont trouvées")
    })
    public List<Formation> findAll() {
        return formationService.findAll();
    }

    @PostMapping
    @ApiOperation(value="enregistrer une formation", notes="save formation")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="la formation est enregistrée")
    })
    public MessageResponse save(@RequestBody Formation formation) {
        return formationService.save(formation);
    }

    @PutMapping
    @ApiOperation(value="Mise à jour formation", notes="update formation")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="Formation Mise à jour")
    })
    public MessageResponse update(@RequestBody Formation formation) {
        return formationService.update(formation);
    }

    @GetMapping("/{code}")
    @PutMapping
    @ApiOperation(value="Trouver une formation par id", notes="trouver par id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="Formation trouvée")
    })
    public Formation findById(@PathVariable("code") Long id) {
        return formationService.findById(id);
    }
    
    @PutMapping
    @ApiOperation(value="Supprimer une formation par id", notes="supression formation")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="Formation supprimée")
    })
    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return formationService.delete(id);
    }
}

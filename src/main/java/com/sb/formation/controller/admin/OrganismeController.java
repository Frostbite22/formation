package com.sb.formation.controller.admin;

import com.sb.formation.entities.Organisme;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.OrganismeServiceImpl;

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
@RequestMapping("/organisme")
@PreAuthorize("hasRole('ROLE_USER')")
public class OrganismeController {
    @Autowired
    private OrganismeServiceImpl organismeService;

    @GetMapping
    @ApiOperation(value="trouver tous les organismes", notes="find all organismes")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="organismes trouvés")
    })
    public List<Organisme> findAll() {
        return organismeService.findAll();
    }

    @PostMapping
    @ApiOperation(value="enregistrer un organisme", notes="save organisme")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="organisme enregistré")
    })
    public MessageResponse save(@RequestBody Organisme organisme) {
        return organismeService.save(organisme);
    }

    @PutMapping
    @ApiOperation(value="Mettre à jour un organisme", notes="update organisme")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="organisme mis à jour")
    })
    public MessageResponse update(@RequestBody Organisme organisme) {
        return organismeService.update(organisme);
    }

    @GetMapping("/{code}")
    @ApiOperation(value="trouver un organisme par id", notes="find organisme par id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="organisme trouvé")
    })
    public Organisme findById(@PathVariable("code") Long id) {
        return organismeService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Supprimer un organisme", notes="delete organisme")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="organisme supprimé")
    })
    public MessageResponse delete(@PathVariable Long id) {
        return organismeService.delete(id);
    }
}

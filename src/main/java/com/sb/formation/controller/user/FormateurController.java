package com.sb.formation.controller.user;

import com.sb.formation.entities.Formateur;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.FormateurServiceImpl;

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
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/formateur")
@PreAuthorize("hasRole('ROLE_USER')")
public class FormateurController {
    @Autowired
    private FormateurServiceImpl formateurService;

    @GetMapping
    @ApiOperation(value="Trouver tous les formateurs", notes="find formateur")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="formateur trouvé")
    })
    public List<Formateur> findAll() {
        return formateurService.findAll();
    }

    @PostMapping
    @ApiOperation(value="Enregistrer un formateur", notes="save formateur")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="formateur enregistrer")
    })
    public MessageResponse save(@RequestBody Formateur formateur) {
        return formateurService.save(formateur);
    }

    @PutMapping
    @ApiOperation(value="mettre à jour un formateur", notes="update formateur")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="formateur mis à jour")
    })
    public MessageResponse update(@RequestBody Formateur formateur) {
        return formateurService.update(formateur);
    }

    @GetMapping("/{code}")
    @ApiOperation(value="Trouver un formateur par id", notes="find formateur par id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="formateur trouvé")
    })
    public Formateur findById(@PathVariable("code") Long id) {
        return formateurService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="supprimer un formateur par id", notes="supprimer formateur par id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="formateur supprimé")
    })
    public MessageResponse delete(@PathVariable Long id) {
        return formateurService.delete(id);
    }
}

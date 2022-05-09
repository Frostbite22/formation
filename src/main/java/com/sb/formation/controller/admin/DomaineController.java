package com.sb.formation.controller.admin;

import com.sb.formation.entities.Domaine;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.DomaineServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@Api
@RestController
@CrossOrigin("*")
@RequestMapping("/domaine")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class DomaineController {

    @Autowired
    private DomaineServiceImpl domaineService;

    @GetMapping
    @ApiOperation(value="Trouver tous les domaines", notes="find domaines")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="domaines trouvés")
    })
    public List<Domaine> findAll() {
        return domaineService.findAll();
    }

    @PostMapping
    @ApiOperation(value="Enregister un domaine", notes="save domaine",authorizations = {@Authorization(value="jwtToken") })
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="domaine enregistré")
    })
    public MessageResponse save(@RequestBody Domaine domaine) {
        return domaineService.save(domaine);
    }

    @PutMapping
    @ApiOperation(value="mettre à jour un domaine", notes="update domaine")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="domaine mis à jour")
    })
    public MessageResponse update(@RequestBody Domaine domaine) {
        return domaineService.update(domaine);
    }

   @GetMapping("/{code}")
   @ApiOperation(value="Trouver un domaine par id", notes="find domaine par id")
   @ApiResponses(value = {
   		@ApiResponse(code = 200, message="domaine trouvé")
   })
    public Domaine findById(@PathVariable("code") Long id) {
        return domaineService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="supprimer un domaine", notes="delete domaine")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="domaine supprimé")
    })
    public MessageResponse delete(@PathVariable Long id) {
        return domaineService.delete(id);
    }
}



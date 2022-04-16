package com.sb.formation.controller.user;

import com.sb.formation.entities.Formation;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.FormationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/formation")
@PreAuthorize("hasRole('ROLE_USER')")
public class FormationController {
    @Autowired
    private FormationServiceImpl formationService;

    @GetMapping
    public List<Formation> findAll() {
        return formationService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Formation formation) {
        return formationService.save(formation);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Formation formation) {
        return formationService.update(formation);
    }

    @GetMapping("/{code}")
    public Formation findById(@PathVariable("code") Long id) {
        return formationService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return formationService.delete(id);
    }
}

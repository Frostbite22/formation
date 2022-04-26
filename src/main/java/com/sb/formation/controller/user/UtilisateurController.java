package com.sb.formation.controller.user;

import com.sb.formation.entities.Utilisateur;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.UtilisateurServiceImpl;

import io.swagger.annotations.Api;

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
    public List<Utilisateur> findAll() {
        return utilisateurServiceImpl.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Utilisateur utilisateur) {
        return utilisateurServiceImpl.save(utilisateur);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Utilisateur utilisateur) {
        return utilisateurServiceImpl.update(utilisateur);
    }

    @GetMapping("/{code}")
    public Utilisateur findById(@PathVariable("code") Long code) {
        return utilisateurServiceImpl.findByCode(code);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long code) {
        return utilisateurServiceImpl.delete(code);
    }
}

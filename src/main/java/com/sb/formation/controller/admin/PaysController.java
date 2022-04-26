package com.sb.formation.controller.admin;

import com.sb.formation.entities.Pays;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.PaysServiceImpl;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@CrossOrigin("*")
@RequestMapping("/pays")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class PaysController {
    @Autowired
    private PaysServiceImpl paysServiceImpl;

    @GetMapping
    public List<Pays> findAll() {
        return paysServiceImpl.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Pays pays) {
        return paysServiceImpl.save(pays);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Pays pays) {
        return paysServiceImpl.update(pays);
    }

    @GetMapping("/{code}")
    public Pays findById(@PathVariable("code") Long id) {
        return paysServiceImpl.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return paysServiceImpl.delete(id);
    }
}

package com.sb.formation.controller.user;

import com.sb.formation.entities.Session;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.SessionServiceImpl;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@CrossOrigin("*")
@RequestMapping("/session")
@PreAuthorize("hasRole('ROLE_USER')")
public class SessionController {
    @Autowired
    private SessionServiceImpl sessionServiceImpl;

    @GetMapping
    public List<Session> findAll() {
        return sessionServiceImpl.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Session session) {
        return sessionServiceImpl.save(session);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Session session) {
        return sessionServiceImpl.update(session);
    }

    @GetMapping("/{code}")
    public Session findById(@PathVariable("code") Long id) {
        return sessionServiceImpl.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return sessionServiceImpl.delete(id);
    }
}

package com.sb.formation.controller.user;

import com.sb.formation.entities.Participant;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.ParticipantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/participant")
@PreAuthorize("hasRole('ROLE_USER')")
public class ParticipantController {
    @Autowired
    private ParticipantServiceImpl participantService;

    @GetMapping
    public List<Participant> findAll() {
        return participantService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Participant participant) {
        return participantService.save(participant);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Participant participant) {
        return participantService.update(participant);
    }

    @GetMapping("/{code}")
    public Participant findById(@PathVariable("code") Long id) {
        return participantService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return participantService.delete(id);
    }
}

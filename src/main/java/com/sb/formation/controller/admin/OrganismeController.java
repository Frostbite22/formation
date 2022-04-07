package com.sb.formation.controller.admin;

import com.sb.formation.entities.Organisme;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.OrganismeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/organisme")
public class OrganismeController {
    @Autowired
    private OrganismeServiceImpl organismeService;

    @GetMapping
    public List<Organisme> findAll() {
        return organismeService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Organisme organisme) {
        return organismeService.save(organisme);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Organisme organisme) {
        return organismeService.update(organisme);
    }

    @GetMapping("/{code}")
    public Organisme findById(@PathVariable("code") Long id) {
        return organismeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return organismeService.delete(id);
    }
}

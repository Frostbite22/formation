package com.sb.formation.controller.admin;

import com.sb.formation.entities.Domaine;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.DomaineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
@CrossOrigin("*")
@RequestMapping("/domaine")
public class DomaineController {

    @Autowired
    private DomaineServiceImpl domaineService;

    @GetMapping
    public List<Domaine> findAll() {
        return domaineService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Domaine domaine) {
        return domaineService.save(domaine);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Domaine domaine) {
        return domaineService.update(domaine);
    }

   @GetMapping("/{code}")
    public Domaine findById(@PathVariable("code") Long id) {
        return domaineService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return domaineService.delete(id);
    }
}



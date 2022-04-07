package com.sb.formation.controller.admin;

import com.sb.formation.entities.Profile;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileServiceImpl profileServiceImpl;
    @GetMapping
    public List<Profile> findAll() {
        return profileServiceImpl.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Profile profile) {
        return profileServiceImpl.save(profile);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Profile profile) {
        return profileServiceImpl.update(profile);
    }

    @GetMapping("/{code}")
    public Profile findById(@PathVariable("code") Long id) {
        return profileServiceImpl.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return profileServiceImpl.delete(id);
    }
}

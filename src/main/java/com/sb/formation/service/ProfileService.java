package com.sb.formation.service;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Profile;
import com.sb.formation.reponses.MessageResponse;

import java.util.List;

public interface ProfileService {
    public MessageResponse save(Profile profile);
    public MessageResponse update(Profile profile);
    public MessageResponse delete(Long id);
    public List<Profile> findAll();
    public Profile findById(Long id);
}

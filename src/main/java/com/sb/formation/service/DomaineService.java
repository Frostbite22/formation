package com.sb.formation.service;

import com.sb.formation.entities.Domaine;
import com.sb.formation.reponses.MessageResponse;

import java.util.List;

public interface DomaineService {
    public MessageResponse save(Domaine domaine);
    public MessageResponse update(Domaine domaine);
    public MessageResponse delete(Long id);
    public List<Domaine> findAll();
    public Domaine findById(Long id);
}

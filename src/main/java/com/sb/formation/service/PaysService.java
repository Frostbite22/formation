package com.sb.formation.service;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Pays;
import com.sb.formation.reponses.MessageResponse;

import java.util.List;

public interface PaysService {
    public MessageResponse save(Pays pays);
    public MessageResponse update(Pays pays);
    public MessageResponse delete(Long id);
    public List<Pays> findAll();
    public Pays findById(Long id);
}

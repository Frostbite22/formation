package com.sb.formation.service;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Organisme;
import com.sb.formation.reponses.MessageResponse;

import java.util.List;

public interface OrganismeService {
    public MessageResponse save(Organisme organisme);
    public MessageResponse update(Organisme organisme);
    public MessageResponse delete(Long id);
    public List<Organisme> findAll();
    public Organisme findById(Long id);
}

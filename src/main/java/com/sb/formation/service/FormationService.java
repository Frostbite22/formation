package com.sb.formation.service;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Formation;
import com.sb.formation.reponses.MessageResponse;

import java.util.List;

public interface FormationService {
    public MessageResponse save(Formation formation);
    public MessageResponse update(Formation formation);
    public MessageResponse delete(Long id);
    public List<Formation> findAll();
    public Formation findById(Long id);
}

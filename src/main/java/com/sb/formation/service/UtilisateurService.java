package com.sb.formation.service;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Utilisateur;
import com.sb.formation.reponses.MessageResponse;

import java.util.List;

public interface UtilisateurService {
    public MessageResponse save(Utilisateur utilisateur);
    public MessageResponse update(Utilisateur utilisateur);
    public MessageResponse delete(Long code);
    public List<Utilisateur> findAll();
    public Utilisateur findByCode(Long code);
}

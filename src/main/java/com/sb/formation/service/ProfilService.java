package com.sb.formation.service;

import com.sb.formation.entities.Profil;
import com.sb.formation.reponses.MessageResponse;

import java.util.List;

public interface ProfilService {
    public MessageResponse save(Profil profil);
    public MessageResponse update(Profil profil);
    public MessageResponse delete(Long id);
    public List<Profil> findAll();
    public Profil findById(Long id);
}

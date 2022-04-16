package com.sb.formation.service;

import com.sb.formation.entities.Profil;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfilServiceImpl implements ProfilService {
    @Autowired
    ProfilRepository profilRepository;

    @Transactional
    @Override
    public MessageResponse save(Profil profil) {
        boolean existe = profilRepository.existsByLibelle(profil.getLibelle());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette libelle existe déja !");
        }
        profilRepository.save(profil);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(Profil profil) {
        boolean existe = profilRepository.existsById(profil.getId());
        if (!existe){
            boolean existe1 = profilRepository.existsByLibelle(profil.getLibelle());
            return new MessageResponse(false,"Echec !","Cette libelle existe déja !");
        }
        profilRepository.save(profil);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Profil profil = findById(id);
        if (profil==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        profilRepository.delete(profil);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Transactional
    @Override
    public List<Profil> findAll() {
        return profilRepository.findAll();
    }

    @Transactional
    @Override
    public Profil findById(Long id) {
        Profil profil = profilRepository.findById(id).orElse(null);
        return profil;
    }
}

package com.sb.formation.service;

import com.sb.formation.entities.Profile;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    ProfileRepository profileRepository;

    @Transactional
    @Override
    public MessageResponse save(Profile profile) {
        boolean existe = profileRepository.existsByLibelle(profile.getLibelle());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette libelle existe déja !");
        }
        profileRepository.save(profile);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(Profile profile) {
        boolean existe = profileRepository.existsById(profile.getId());
        if (!existe){
            boolean existe1 = profileRepository.existsByLibelle(profile.getLibelle());
            return new MessageResponse(false,"Echec !","Cette libelle existe déja !");
        }
        profileRepository.save(profile);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Profile profile = findById(id);
        if (profile==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        profileRepository.delete(profile);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Transactional
    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Transactional
    @Override
    public Profile findById(Long id) {
        Profile profile = profileRepository.findById(id).orElse(null);
        return profile;
    }
}

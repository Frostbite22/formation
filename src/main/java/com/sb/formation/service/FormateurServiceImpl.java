package com.sb.formation.service;

import com.sb.formation.entities.Formateur;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormateurServiceImpl implements FormateurService{
    @Autowired
    FormateurRepository formateurRepository;

    @Transactional
    @Override
    public MessageResponse save(Formateur formateur) {
        boolean existe = formateurRepository.existsByEmail(formateur.getEmail());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette formateur existe déja !");
        }
        formateurRepository.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(Formateur formateur) {
        boolean existe = formateurRepository.existsById(formateur.getId());
        if (!existe){
            boolean existe1 = formateurRepository.existsByEmail(formateur.getEmail());
            return new MessageResponse(false,"Echec !","Cette formateur existe déja !");

        }
        formateurRepository.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Formateur formateur = findById(id);
        if (formateur==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        formateurRepository.delete(formateur);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Transactional
    @Override
    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }

    @Transactional
    @Override
    public Formateur findById(Long id) {
        Formateur formateur = formateurRepository.findById(id).orElse(null);
        return formateur;
    }
}

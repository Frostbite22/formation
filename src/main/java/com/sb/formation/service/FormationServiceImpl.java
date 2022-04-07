package com.sb.formation.service;

import com.sb.formation.entities.Formation;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormationServiceImpl implements FormationService{
    @Autowired
    FormationRepository formationRepository;

    @Transactional
    @Override
    public MessageResponse save(Formation formation) {
        boolean existe = formationRepository.existsByTitre(formation.getTitre());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette formation existe déja !");
        }
        formationRepository.save(formation);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(Formation formation) {
        boolean existe = formationRepository.existsById(formation.getId());
        if (!existe){
            boolean existe1 = formationRepository.existsByTitre(formation.getTitre());
            return new MessageResponse(false,"Echec !","Cette formation existe déja !");

        }
        formationRepository.save(formation);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Formation formation = findById(id);
        if (formation==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        formationRepository.delete(formation);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Transactional
    @Override
    public List<Formation> findAll() {
        return formationRepository.findAll();
    }

    @Transactional
    @Override
    public Formation findById(Long id) {
        Formation formation = formationRepository.findById(id).orElse(null);
        return formation;
    }
}

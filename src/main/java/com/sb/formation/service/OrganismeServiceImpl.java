package com.sb.formation.service;

import com.sb.formation.entities.Organisme;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.OrganismeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganismeServiceImpl implements OrganismeService{
    @Autowired
    OrganismeRepository organismeRepository;

    @Transactional
    @Override
    public MessageResponse save(Organisme organisme) {
        boolean existe = organismeRepository.existsByLibelle(organisme.getLibelle());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette libelle existe déja !");
        }
        organismeRepository.save(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(Organisme organisme) {
        boolean existe = organismeRepository.existsById(organisme.getId());
        if (!existe){
            boolean existe1 = organismeRepository.existsByLibelle(organisme.getLibelle());
            return new MessageResponse(false,"Echec !","Cette formation existe déja !");

        }
        organismeRepository.save(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Organisme organisme = findById(id);
        if (organisme==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        organismeRepository.delete(organisme);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Transactional
    @Override
    public List<Organisme> findAll() {
        return organismeRepository.findAll();
    }

    @Transactional
    @Override
    public Organisme findById(Long id) {
        Organisme organisme = organismeRepository.findById(id).orElse(null);
        return organisme;
    }
}

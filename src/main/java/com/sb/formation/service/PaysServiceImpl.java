package com.sb.formation.service;

import com.sb.formation.entities.Pays;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaysServiceImpl implements PaysService{
    @Autowired
    PaysRepository paysRepository;

    @Transactional
    @Override
    public MessageResponse save(Pays pays) {
        boolean existe = paysRepository.existsByName(pays.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette nom existe déja !");
        }
        paysRepository.save(pays);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(Pays pays) {
        boolean existe = paysRepository.existsById(pays.getId());
        if (!existe){
            boolean existe1 = paysRepository.existsByName(pays.getNom());
            return new MessageResponse(false,"Echec !","Cette pays existe déja !");
        }
        paysRepository.save(pays);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Pays pays = findById(id);
        if (pays==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        paysRepository.delete(pays);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Transactional
    @Override
    public List<Pays> findAll() {
        return paysRepository.findAll();
    }


    @Transactional
    @Override
    public Pays findById(Long id) {
        Pays pays = paysRepository.findById(id).orElse(null);
        return pays;
    }
}

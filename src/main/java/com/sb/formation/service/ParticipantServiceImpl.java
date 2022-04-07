package com.sb.formation.service;

import com.sb.formation.entities.Participant;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService{
    @Autowired
    ParticipantRepository participantRepository;

    @Transactional
    @Override
    public MessageResponse save(Participant participant) {
        boolean existe = participantRepository.existsByEmail(participant.getEmail());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette email existe déja !");
        }
        participantRepository.save(participant);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(Participant participant) {
        boolean existe = participantRepository.existsById(participant.getId());
        if (!existe){
            boolean existe1 = participantRepository.existsByEmail(participant.getEmail());
            return new MessageResponse(false,"Echec !","Cette formation existe déja !");
        }
        participantRepository.save(participant);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Participant participant = findById(id);
        if (participant==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        participantRepository.delete(participant);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Transactional
    @Override
    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    @Transactional
    @Override
    public Participant findById(Long id) {
        Participant participant = participantRepository.findById(id).orElse(null);
        return participant;
    }
}

package com.sb.formation.service;

import com.sb.formation.entities.Participant;
import com.sb.formation.reponses.MessageResponse;

import java.util.List;

public interface ParticipantService {
    public MessageResponse save(Participant participant);
    public MessageResponse update(Participant participant);
    public MessageResponse delete(Long id);
    public List<Participant> findAll();
    public Participant findById(Long id);
}

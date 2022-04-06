package com.sb.formation.service;

import com.sb.formation.entities.Participant;
import com.sb.formation.reponses.MessageResponse;

import java.util.List;

public interface ParticipantService {
    public MessageResponse save(Participant participant_session);
    public MessageResponse update(Participant participant_session);
    public MessageResponse delete(Long id);
    public List<Participant> findAll();
    public Participant findById(Long id);
}

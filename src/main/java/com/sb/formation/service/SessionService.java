package com.sb.formation.service;

import com.sb.formation.entities.Session;
import com.sb.formation.reponses.MessageResponse;

import java.util.List;

public interface SessionService {
    public MessageResponse save(Session session_de_formation);
    public MessageResponse update(Session session_de_formation);
    public MessageResponse delete(Long id);
    public List<Session> findAll();
    public Session findById(Long id);
}

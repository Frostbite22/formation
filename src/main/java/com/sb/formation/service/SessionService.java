package com.sb.formation.service;

import com.sb.formation.entities.Session;
import com.sb.formation.reponses.MessageResponse;

import java.util.List;

public interface SessionService {
    public MessageResponse save(Session session);
    public MessageResponse update(Session session);
    public MessageResponse delete(Long id);
    public List<Session> findAll();
    public Session findById(Long id);
}

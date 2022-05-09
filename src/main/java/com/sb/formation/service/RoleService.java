package com.sb.formation.service;

import java.util.List;

import com.sb.formation.entities.Role;
import com.sb.formation.reponses.MessageResponse;

public interface RoleService {
    public MessageResponse save(Role role);
    public MessageResponse update(Role role);
    public MessageResponse delete(Long id);
    public List<Role> findAll();
    public Role findById(Long id);
}

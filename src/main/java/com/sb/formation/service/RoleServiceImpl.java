package com.sb.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.formation.entities.Profil;
import com.sb.formation.entities.Role;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

	@Override
	public MessageResponse save(Role role) {
        boolean existe = roleRepository.existsByNom(role.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette nom existe déja !");
        }
        roleRepository.save(role);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");

	}

	@Override
	public MessageResponse update(Role role) {
        boolean existe = roleRepository.existsById(role.getId());
        if (!existe){
            boolean existe1 = roleRepository.existsByNom(role.getNom());
            return new MessageResponse(false,"Echec !","Cette role existe déja !");
        }
        roleRepository.save(role);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");

	}

	@Override
	public MessageResponse delete(Long id) {
        Role role = findById(id);
        if (role==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        roleRepository.delete(role);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");

	}

	@Override
	public List<Role> findAll() {
        return roleRepository.findAll();
	}

	@Override
	public Role findById(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        return role;
	}

}

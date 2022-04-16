package com.sb.formation.repository;

import com.sb.formation.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RepositoryRestResource
@CrossOrigin("*")
public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByLogin(String login);
    Boolean existsByLogin(String login);
}

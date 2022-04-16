package com.sb.formation.repository;

import com.sb.formation.entities.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface PaysRepository  extends JpaRepository<Pays, Long> {
    boolean existsByNom(String nom);
}

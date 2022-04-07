package com.sb.formation.repository;

import com.sb.formation.entities.Organisme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface OrganismeRepository  extends JpaRepository<Organisme, Long> {
    boolean existsByLibelle(String libelle);
}

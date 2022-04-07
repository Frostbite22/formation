package com.sb.formation.repository;

import com.sb.formation.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface FormationRepository  extends JpaRepository<Formation, Long> {
    boolean existsByTitre(String titre);
}

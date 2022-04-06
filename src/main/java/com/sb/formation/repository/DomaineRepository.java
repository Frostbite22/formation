package com.sb.formation.repository;

import com.sb.formation.entities.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin("*")
public interface DomaineRepository extends JpaRepository<Domaine, Long> {

    boolean existsByLibelle(String libelle);
}

package com.sb.formation.repository;

import com.sb.formation.entities.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProfilRepository extends JpaRepository<Profil, Long> {
    boolean existsByLibelle(String libelle);
}

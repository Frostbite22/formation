package com.sb.formation.repository;

import com.sb.formation.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProfileRepository  extends JpaRepository<Profile, Long> {
}

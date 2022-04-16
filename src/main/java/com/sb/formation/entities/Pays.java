package com.sb.formation.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Pays {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=75)
	@NotNull
	private String nom;
	@OneToMany(mappedBy="pays")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Participant> participants;
}
